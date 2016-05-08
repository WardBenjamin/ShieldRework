package com.voxmods.shieldrework.registry;

import com.voxmods.shieldrework.item.ItemMod;
import com.voxmods.shieldrework.item.ItemShieldCustom;
import com.voxmods.shieldrework.util.Constants;
import com.voxmods.shieldrework.util.helpers.RenderHelper;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.HashSet;

public class ModItems {
    public static ItemShieldCustom SHIELD_BONE;
    public static ItemShieldCustom SHIELD_IRON;
    public static ItemShieldCustom SHIELD_BRONZE;
    public static ItemShieldCustom SHIELD_STEEL;

    private static HashSet<Item> MOD_ITEMS = new HashSet<>();

    public static void init() {
        SHIELD_BONE = (ItemShieldCustom)registerItem(new ItemShieldCustom("bone", "bone"), "shieldBone");
        SHIELD_IRON = (ItemShieldCustom)registerItem(new ItemShieldCustom("iron", "ingotIron"), "shieldIron");
        SHIELD_BRONZE = (ItemShieldCustom)registerItem(new ItemShieldCustom("bronze", "ingotBronze"), "shieldBronze");
        SHIELD_STEEL = (ItemShieldCustom)registerItem(new ItemShieldCustom("steel", "ingotSteel"), "shieldSteel");
    }

    public static void initRenders() {
        MOD_ITEMS.stream().filter(item -> item != null).forEach(item -> {
            if (item instanceof ItemMod)
                ((ItemMod) item).initRender();
            else
                RenderHelper.registerRender(item, 0, item.getRegistryName().getResourcePath(), "inventory");
        });
    }

    private static Item registerItem(Item item, String name) {
        ResourceLocation registryName = item.getRegistryName();
        if (registryName == null) {
            item.setRegistryName(Constants.Mod.DOMAIN, name);
        }

        GameRegistry.register(item);

        MOD_ITEMS.add(item);

        return item;
    }
}
