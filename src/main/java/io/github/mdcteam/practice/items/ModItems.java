package io.github.mdcteam.practice.items;

import io.github.mdcteam.practice.PracticeMod;
import io.github.mdcteam.practice.blocks.ModBlocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber
public class ModItems {

    public static final List<Item> MOD_ITEMS = new ArrayList<>();

    public static ItemBasicArmor[] practiceArmor;

    public static <I extends Item> I[] addItems(I[] items) {
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

        practiceArmor = addItems(ItemBasicArmor.createArmorSet("practice", ItemArmor.ArmorMaterial.IRON));
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
