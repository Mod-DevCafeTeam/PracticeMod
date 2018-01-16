package io.github.mdcteam.practice.armor;

import io.github.mdcteam.practice.PracticeMod;
import net.minecraft.item.ItemArmor;
import net.minecraft.util.ResourceLocation;

public class PracticeArmor extends ArmorBase {
    public PracticeArmor() {
        super(new ResourceLocation(PracticeMod.MOD_ID, "practiceArmor"), ItemArmor.ArmorMaterial.IRON, true, true, true, true);
    }
}
