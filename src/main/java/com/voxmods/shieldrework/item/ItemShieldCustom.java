package com.voxmods.shieldrework.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemShield;

public class ItemShieldCustom extends ItemShield {
    private Item ingot;

    public ItemShieldCustom(Item ingot)
    {
        this.ingot = ingot;
    }
}
