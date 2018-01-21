package io.github.mdcteam.practice.items;

import io.github.mdcteam.practice.PracticeMod;
import io.github.mdcteam.practice.util.ClientUtils;
import io.github.mdcteam.practice.util.JsonModelBiped;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class ItemTestArmor extends ItemBasicArmor {

    public static final ModelBiped modelChest = new JsonModelBiped(1.0f, new ResourceLocation(PracticeMod.MOD_ID, "entity/glass-head"));
    public static final ModelBiped model = new JsonModelBiped(0.5f, new ResourceLocation(PracticeMod.MOD_ID, "entity/glass-head"));

    public static final ModelBiped modelChest2 = new JsonModelBiped(1.0f, new ResourceLocation(PracticeMod.MOD_ID, "entity/test"));
    public static final ModelBiped model2 = new JsonModelBiped(0.5f, new ResourceLocation(PracticeMod.MOD_ID, "entity/test"));

    public ItemTestArmor(ArmorMaterial material, EntityEquipmentSlot slot) {
        super(material, slot);
    }

    @Nullable
    @SideOnly(Side.CLIENT)
    @Override
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {
        if (itemStack != null && itemStack != ItemStack.EMPTY && itemStack.getItem() instanceof ItemArmor) {

            ModelBiped armorModel = null;

            switch (((ItemArmor) itemStack.getItem()).armorType) {
                case HEAD:
                case LEGS:
                    armorModel = model2;
                    break;

                case FEET:
                case CHEST:
                    armorModel = modelChest2;
                    break;

                default:
                    break;
            }

            ClientUtils.setModelParamsFromSlot(armorModel, armorSlot);
            ClientUtils.copyModelParams(_default, armorModel);

            return armorModel;
        } else {
            return null;
        }
    }
}
