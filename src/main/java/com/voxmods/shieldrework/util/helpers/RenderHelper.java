package com.voxmods.shieldrework.util.helpers;

import com.voxmods.shieldrework.util.Constants;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class RenderHelper {
    /*
    This should only be used if the ItemBlock belonging to the block has already
    been registered, as in ModBlocks.registerBlock(), or else this will crash.
     */
    public static void registerRender(Block block, int meta, String name, String variant)
    {
        registerRender(Item.getItemFromBlock(block), meta, name, variant);
    }

    public static void registerRender(Item item, int meta, String name, String variant)
    {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(Constants.Mod.DOMAIN + name, variant));
    }
}
