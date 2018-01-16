package io.github.mdcteam.practice;

import io.github.mdcteam.practice.kotlin.KSetup;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = PracticeMod.MOD_ID, name = PracticeMod.NAME, version = PracticeMod.VERSION)
public class PracticeMod
{
    public static final String MOD_ID = "practice";
    public static final String NAME = "Practice Mod";
    public static final String VERSION = "@VERSION@"; //Don't change this - it's being replaced by the build.gradle

    @EventHandler
    public static void preInit(FMLPreInitializationEvent e) {
        System.out.println("ITS DA PRACTICE MOD");
        KSetup.INSTANCE.preInit(e);
    }

    @EventHandler
    public static void init(FMLInitializationEvent e) {

    }

    @EventHandler
    public static void postInit(FMLPostInitializationEvent e) {

    }

}
