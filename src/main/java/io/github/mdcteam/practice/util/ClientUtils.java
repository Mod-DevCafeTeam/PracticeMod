package io.github.mdcteam.practice.util;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientUtils {

    public static void copyModelParams(ModelBiped one, ModelBiped two) {
        two.isSneak = one.isSneak;
        two.isRiding = one.isRiding;
        two.isChild = one.isChild;
        two.rightArmPose = one.rightArmPose;
        two.leftArmPose = one.leftArmPose;
    }

    public static void setModelParamsFromSlot(ModelBiped armorModel, EntityEquipmentSlot armorSlot) {
        armorModel.bipedHead.showModel = armorSlot == EntityEquipmentSlot.HEAD;
        armorModel.bipedHeadwear.showModel = armorSlot == EntityEquipmentSlot.HEAD;

        armorModel.bipedBody.showModel = (armorSlot == EntityEquipmentSlot.CHEST);
        armorModel.bipedRightArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
        armorModel.bipedLeftArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;

        armorModel.bipedRightLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS) || (armorSlot == EntityEquipmentSlot.FEET);
        armorModel.bipedLeftLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS) || (armorSlot == EntityEquipmentSlot.FEET);
    }

}
