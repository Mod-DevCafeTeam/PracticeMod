package io.github.mdcteam.practice.items;

import com.google.common.collect.Sets;
import io.github.mdcteam.practice.PracticeMod;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.EnumHelper;

import java.util.HashSet;
import java.util.Set;

public class ItemBasicArmor extends ItemArmor {

    public static ItemBasicArmor[] createArmorSet(String name, int durability, int[] reductions, int enchantability, float toughness, EntityEquipmentSlot... equipmentSlots) {
        ResourceLocation resLoc = new ResourceLocation(PracticeMod.MOD_ID, name);
        return createArmorSet(name, EnumHelper.addArmorMaterial(resLoc + "_material", resLoc.toString(), durability, reductions, enchantability, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, toughness), equipmentSlots);
    }

    public static ItemBasicArmor[] createArmorSet(String name, ArmorMaterial material, EntityEquipmentSlot... equipmentSlots) {
        Set<ItemBasicArmor> armorSet = new HashSet<>();
        if(equipmentSlots.length == 0) equipmentSlots = new EntityEquipmentSlot[] {EntityEquipmentSlot.HEAD, EntityEquipmentSlot.CHEST, EntityEquipmentSlot.LEGS, EntityEquipmentSlot.FEET};
        Set<EntityEquipmentSlot> slotSet = Sets.newHashSet(equipmentSlots);
        slotSet.forEach(slot -> {
            if (slot.getSlotType() != EntityEquipmentSlot.Type.ARMOR)
                throw new IllegalArgumentException("Cannot create armour from the equipment slot type " + slot);
            String itemName = name + "_" + slot.getName();
            ItemBasicArmor armor = (ItemBasicArmor) new ItemBasicArmor(material, slot)
                    .setRegistryName(PracticeMod.MOD_ID, itemName)
                    .setUnlocalizedName(itemName)
                    .setCreativeTab(PracticeMod.TAB);
            armorSet.add(armor);
        });
        return armorSet.toArray(new ItemBasicArmor[armorSet.size()]);
    }

    public ItemBasicArmor(String name, int durability, int[] reductions, int enchantability, float toughness, EntityEquipmentSlot equipmentSlot) {
        this(new ResourceLocation(PracticeMod.MOD_ID, name), durability, reductions, enchantability, toughness, equipmentSlot);
    }

    private ItemBasicArmor(ResourceLocation resLoc, int durability, int[] reductions, int enchantability, float toughness, EntityEquipmentSlot equipmentSlot) {
        super(EnumHelper.addArmorMaterial(resLoc + "_material", resLoc.toString(), durability, reductions, enchantability, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, toughness), -1, equipmentSlot);
    }

    public ItemBasicArmor(ArmorMaterial material, EntityEquipmentSlot equipmentSlot) {
        super(material, -1, equipmentSlot);
    }
}
