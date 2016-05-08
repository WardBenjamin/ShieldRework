package com.voxmods.shieldrework.registry;

import com.voxmods.shieldrework.util.Constants;
import com.voxmods.shieldrework.util.helpers.RenderHelper;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.HashSet;

public class ModBlocks {
    //public static final BlockExample EXAMPLE_BLOCK;

    private static final HashSet<Block> MOD_BLOCKS = new HashSet<>();

    static {
        //EXAMPLE_BLOCK = (BlockExample)registerBlock(new BlockExample(), "blockExample");
    }

    public static void init() {
        // Dummy method to make sure static initializer runs
    }

    public static void initRenders() {
        MOD_BLOCKS.stream().filter(block -> block != null).forEach(block -> {
            Item item = Item.getItemFromBlock(block);
            if (item != null) {
                RenderHelper.registerRender(item, 0, item.getRegistryName().getResourcePath(), "inventory");
            }
        });
    }

    private static Block registerBlock(Block block, String name) {
        ResourceLocation registryName = block.getRegistryName();
        if (registryName == null) {
            registryName = block.setRegistryName(Constants.Mod.MOD_ID, name).getRegistryName();
        }
        ItemBlock item = (ItemBlock) (new ItemBlock(block).setRegistryName(registryName));

        GameRegistry.register(block);
        GameRegistry.register(item);

        MOD_BLOCKS.add(block);

        return block;
    }
}
