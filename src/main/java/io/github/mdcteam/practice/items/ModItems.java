package io.github.mdcteam.practice.items;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.HashMap;

@Mod.EventBusSubscriber
public class ModItems {

    // TODO: Use something better than a hash map
    public static final HashMap<String, Item> MOD_ITEMS = new HashMap<>();

    @SubscribeEvent
    public static void registerItems(RegistryEvent<Item> e) {

    }

}
