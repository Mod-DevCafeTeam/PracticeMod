package io.github.mdcteam.practice.items;

import io.github.mdcteam.practice.PracticeMod;
import io.github.mdcteam.practice.armor.PracticeArmor;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.HashMap;

@Mod.EventBusSubscriber
public class ModItems {

    // TODO: Use something better than a hash map
    public static final HashMap<String, Item> MOD_ITEMS = new HashMap<>();

    public static void init() {
        registerItem(new Item(), "practiceItem");

        new PracticeArmor(); // This class auto-registers its items
    }

    public static Item registerItem(Item item, String name) {
        MOD_ITEMS.put(name, item);
        item.setRegistryName(PracticeMod.MOD_ID+":"+name);
        item.setUnlocalizedName(PracticeMod.MOD_ID+"."+name);

        return item;
    }

    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> e) {
        IForgeRegistry<Item> itemForgeRegistry = e.getRegistry();

        for (Item item : MOD_ITEMS.values()) {
            itemForgeRegistry.register(item);
        }
    }

}
