package com.voxmods.shieldrework.override.client;

import com.voxmods.shieldrework.ShieldRework;
import com.voxmods.shieldrework.config.EnumShieldBehavior;
import com.voxmods.shieldrework.util.Constants;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static net.minecraft.init.Items.shield;

public class ShieldClientOverride {
    private static final ModelResourceLocation override_location =
            new ModelResourceLocation(Constants.Mod.MOD_PREFIX + "shield_override", "inventory");

    @SideOnly(Side.CLIENT)
    public static void preInitClient(FMLPreInitializationEvent event) {
        // Override the default vanilla shield model and the mesh definition.
        ModelBakery.registerItemVariants(shield, override_location);
        ModelLoader.setCustomMeshDefinition(shield, new ItemMeshDefinition() {
            @Override
            public ModelResourceLocation getModelLocation(ItemStack stack) {
                return override_location;
            }
        });

        // Get the config option for shield behavior
        Configuration config = ShieldRework.config;
        config.load();
        int configBehavior = config.get(Configuration.CATEGORY_GENERAL, "shieldBehavior", 0).getInt();
        EnumShieldBehavior behavior = EnumShieldBehavior.fromInt(configBehavior);
        if(behavior == null)
            behavior = EnumShieldBehavior.DEFAULT;
        config.save();

        // If the configuration is to always lower, make the predicate always return true so that,
        // unless actively blocking, the shield will be lowered.
        if (behavior == EnumShieldBehavior.LOWER_ALWAYS) {
            shield.addPropertyOverride(new ResourceLocation("shieldrework", "blockheld"), new IItemPropertyGetter() {
                @Override
                @SideOnly(Side.CLIENT)
                public float apply(ItemStack stack, World worldIn, EntityLivingBase entityIn) {
                    return 1;
                }
            });
        }
        else if(behavior == EnumShieldBehavior.LOWER_WHEN_HOLDING_BLOCK) {
            shield.addPropertyOverride(new ResourceLocation("shieldrework", "blockheld"), new IItemPropertyGetter() {
                @Override
                public float apply(ItemStack stack, World worldIn, EntityLivingBase entityIn) {
                    if(entityIn instanceof EntityPlayer)
                    {
                        EnumHand hand = EnumHand.MAIN_HAND;
                        EntityPlayer player = (EntityPlayer)entityIn;
                        if(stack == player.getHeldItemMainhand())
                            hand = EnumHand.OFF_HAND;
                        if(player.getHeldItem(hand) != null
                                && player.getHeldItem(hand).getItem() instanceof ItemBlock)
                        {
                            // The player is holding a block
                            return 1;
                        }
                    }
                    return 0;
                }
            });
        }
        else if(behavior == EnumShieldBehavior.HIDE_COMPLETELY) {
            shield.addPropertyOverride(new ResourceLocation("shieldrework", "hideshield"), new IItemPropertyGetter() {
                @Override
                public float apply(ItemStack stack, World worldIn, EntityLivingBase entityIn) {
                    return 1;
                }
            });
        }
    }
}
