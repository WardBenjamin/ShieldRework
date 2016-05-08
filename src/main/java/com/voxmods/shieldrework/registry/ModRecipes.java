package com.voxmods.shieldrework.registry;

import com.voxmods.shieldrework.util.helpers.OreDictHelper;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

import java.util.ArrayList;
import java.util.List;

public class ModRecipes {
    public static void init() {
        //if(!TinkersConstructLoaded)
        removeCraftingRecipes();
        addCraftingRecipes();
    }

    public static void postInit() {
        // TODO: Instead of checking, subscribe to OreDictionary.OreRegisterEvent
        if(OreDictHelper.IsRegistered("ingotBronze"))
            GameRegistry.addRecipe(ModItems.SHIELD_BRONZE.GetRecipe());
        if(OreDictHelper.IsRegistered("ingotSteel"))
            GameRegistry.addRecipe(ModItems.SHIELD_STEEL.GetRecipe());
    }

    private static void removeCraftingRecipes()
    {
        List<IRecipe> recipeList = new ArrayList<>(CraftingManager.getInstance().getRecipeList());
        for(IRecipe recipe : recipeList) {
            ItemStack out = recipe.getRecipeOutput();
            if(out != null && out.getItem() == Items.shield)
                CraftingManager.getInstance().getRecipeList().remove(recipe);
        }
    }

    private static void addCraftingRecipes()
    {
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.shield),
                "wiw", "www", " w ", 'w', "plankWood", 'i', "ingotIron"));
        GameRegistry.addRecipe(ModItems.SHIELD_BONE.GetRecipe());
        GameRegistry.addRecipe(ModItems.SHIELD_IRON.GetRecipe());
    }
}
