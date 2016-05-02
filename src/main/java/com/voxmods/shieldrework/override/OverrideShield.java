package com.voxmods.shieldrework.override;

import com.voxmods.shieldrework.util.Constants;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class OverrideShield {
     private static final ModelResourceLocation location =
            new ModelResourceLocation(Constants.Mod.MOD_PREFIX + "shield_override", "inventory");

    @SideOnly(Side.CLIENT)
    public static void preInitClient(FMLPreInitializationEvent event) {

        ModelBakery.registerItemVariants(Items.shield, location);

        //ModelHandler.registerModels(Items.shield, new String[] { "shield_override" }, true);

        ModelLoader.setCustomMeshDefinition(Items.shield, new ItemMeshDefinition() {
            @Override
            public ModelResourceLocation getModelLocation(ItemStack stack) {
                return location;
            }
        });
    }
}
