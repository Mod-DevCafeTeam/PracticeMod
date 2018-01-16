package io.github.mdcteam.practice.blocks;

import io.github.mdcteam.practice.PracticeMod;
import io.github.mdcteam.practice.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.HashSet;
import java.util.Set;

@Mod.EventBusSubscriber
public class ModBlocks {

    public static Set<Block> MOD_BLOCKS = new HashSet<>();
    public static Set<ItemBlock> MOD_ITEM_BLOCKS = new HashSet<>();

    public static void init() {
        addBlock(new Block(Material.ROCK), "practiceBlock");
    }

    public static Block addBlock(Block block, String name) {
        block.setRegistryName(PracticeMod.MOD_ID, name);
        block.setUnlocalizedName(name);
        block.setCreativeTab(PracticeMod.TAB);
        MOD_BLOCKS.add(block);
        MOD_ITEM_BLOCKS.add((ItemBlock) new ItemBlock(block).setRegistryName(block.getRegistryName()));
        return block;
    }

    public static Block[] getBlocks() {
        if (MOD_BLOCKS.isEmpty()) init();
        return MOD_BLOCKS.toArray(new Block[MOD_BLOCKS.size()]);
    }

    public static ItemBlock[] getItemBlocks() {
        if (MOD_ITEM_BLOCKS.isEmpty()) init();
        return MOD_ITEM_BLOCKS.toArray(new ItemBlock[MOD_ITEM_BLOCKS.size()]);
    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> e) {
        e.getRegistry().registerAll(getBlocks());
    }
}
