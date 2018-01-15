package io.github.mdcteam.practice;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class Main {

    @EventHandler
    public static void preInit(FMLPreInitializationEvent e) {
        System.out.println("ITS DA PRACTICE MOD");
    }

    @EventHandler
    public static void init(FMLInitializationEvent e) {

    }

    @EventHandler
    public static void postInit(FMLPostInitializationEvent e) {

    }

}
