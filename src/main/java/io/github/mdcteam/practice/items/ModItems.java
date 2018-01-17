package io.github.mdcteam.practice.items;

import io.github.mdcteam.practice.PracticeMod;
import io.github.mdcteam.practice.blocks.ModBlocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Mod.EventBusSubscriber
public class ModItems {

    public static final List<Item> MOD_ITEMS = new ArrayList<>();

    public static Set<ItemBasicArmor> practiceArmor;

    public static <I extends Item> I[] addItems(I[] items) {
        for(I item : items) addItem(item);
        return items;
    }

    public static <I extends Item> Set<I> addItems(Set<I> items) {
        for(I item : items) addItem(item);
        return items;
    }

    @SuppressWarnings("unchecked")
    public static <I extends Item> I addItem(I item, String name) {
        return (I) addItem(item
                .setRegistryName(PracticeMod.MOD_ID, name)
                .setUnlocalizedName(name)
                .setCreativeTab(PracticeMod.TAB));
    }

    public static <I extends Item> I addItem(I item) {
        MOD_ITEMS.add(item);
        return item;
    }

    public static void init() {
        addItem(new Item(), "practice_item");

        practiceArmor = addItems(ItemBasicArmor.createArmorSet("practice", 1000, new int[]{1000, 1000, 1000, 1000}, 1000, 1000f, SoundEvents.ITEM_ARMOR_EQUIP_IRON, EntityEquipmentSlot.HEAD, EntityEquipmentSlot.CHEST, EntityEquipmentSlot.LEGS, EntityEquipmentSlot.FEET));
    }

    public static Item[] getItems() {
        if (MOD_ITEMS.isEmpty()) init();
        return MOD_ITEMS.toArray(new Item[MOD_ITEMS.size()]);
    }

    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> e) {
        IForgeRegistry<Item> registry = e.getRegistry();
        registry.registerAll(getItems());
        registry.registerAll(ModBlocks.getItemBlocks());
    }
}
