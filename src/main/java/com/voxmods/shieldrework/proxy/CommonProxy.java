package com.voxmods.shieldrework.proxy;

import com.voxmods.shieldrework.plugin.PluginRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
    PluginRegistry PluginRegistry;

    public void preInit(FMLPreInitializationEvent event) {
        this.PluginRegistry = new PluginRegistry();
    }

    public void init(FMLInitializationEvent event) {
        // NO-OP
    }

    public void postInit(FMLPostInitializationEvent event) {
        // NO-OP
    }

}
