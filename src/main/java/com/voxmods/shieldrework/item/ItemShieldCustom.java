package com.voxmods.shieldrework.item;

import com.voxmods.shieldrework.client.ShieldClientOverride;
import com.voxmods.shieldrework.util.Constants;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemShield;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class ItemShieldCustom extends ItemShield implements ItemMod {
    private String ingot;

    private ItemShieldCustom(String name) {
        super();
        ShieldClientOverride.OverrideBehavior(this);
        setUnlocalizedName(Constants.Mod.MOD_ID + ".shield." + name);
    }

    public ItemShieldCustom(String name, Item ingot) {
        this(name);
        this.ingot = ingot.getUnlocalizedName();
    }

    public ItemShieldCustom(String name, ItemStack ingot) {
        this(name);
        this.ingot = ingot.getItem().getUnlocalizedName();
    }

    public ItemShieldCustom(String name, String ingot) {
        this(name);
        this.ingot = ingot;
    }

    public ShapedOreRecipe GetRecipe() {
        // "b" represents the base material
        return new ShapedOreRecipe(new ItemStack(this), "bib", "bbb", " b ", 'b', ingot, 'i', "ingotIron");
    }

    @Override
    public void initRender() {

    }
}
