package io.github.mdcteam.practice;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = PracticeMod.MOD_ID, name = PracticeMod.NAME, version = PracticeMod.VERSION)
public class PracticeMod {
    public static final String MOD_ID = "practice";
    public static final String NAME = "Practice Mod";
    public static final String VERSION = "@VERSION@"; //Don't change this - it's being replaced by the build.gradle

    public static Logger LOGGER;

    public static final CreativeTabs TAB = new CreativeTabs(MOD_ID) {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(Blocks.IRON_BLOCK);
        }
    };

    @EventHandler
    public static void preInit(FMLPreInitializationEvent e) {
        LOGGER = e.getModLog();
        LOGGER.info("ITS DA PRACTICE MOD");
    }

    @EventHandler
    public static void init(FMLInitializationEvent e) {

    }

    @EventHandler
    public static void postInit(FMLPostInitializationEvent e) {

    }

}
