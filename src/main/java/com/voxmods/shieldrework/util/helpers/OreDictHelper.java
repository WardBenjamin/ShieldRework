package com.voxmods.shieldrework.util.helpers;

import net.minecraftforge.oredict.OreDictionary;

public class OreDictHelper {
    public static boolean IsRegistered(String name)
    {
        return OreDictionary.doesOreNameExist(name) && OreDictionary.getOres(name) != null && OreDictionary.getOres(name).size() > 0;
    }
}
