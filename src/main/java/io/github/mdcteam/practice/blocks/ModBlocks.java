package io.github.mdcteam.practice.blocks;

import io.github.mdcteam.practice.PracticeMod;
import io.github.mdcteam.practice.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.HashMap;

@Mod.EventBusSubscriber
public class ModBlocks {

    // TODO: Use something better than a hash map
    public static final HashMap<String, Block> MOD_BLOCKS = new HashMap<>();

    public static void init() {
        registerBlock(new Block(Material.ROCK), "practiceBlock");
    }

    public static Block registerBlock(Block block, String name) {
        MOD_BLOCKS.put(name, block);
        block.setRegistryName(PracticeMod.MOD_ID+":"+name);
        block.setUnlocalizedName(PracticeMod.MOD_ID+"."+name);

        ModItems.registerItem(new ItemBlock(block), name);

        return block;
    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> e) {
        IForgeRegistry<Block> blockForgeRegistry = e.getRegistry();

        for (Block block : MOD_BLOCKS.values()) {
            blockForgeRegistry.register(block);
        }
    }

}
