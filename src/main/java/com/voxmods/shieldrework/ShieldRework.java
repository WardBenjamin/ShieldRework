package com.voxmods.shieldrework;

import com.voxmods.shieldrework.proxy.CommonProxy;
import com.voxmods.shieldrework.util.Constants;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Constants.Mod.MOD_ID, name = Constants.Mod.MOD_NAME,
        version = Constants.Mod.VERSION, dependencies = Constants.Mod.DEPENDENCIES)
public class ShieldRework {

    @Mod.Instance
    public static ShieldRework instance;

    public static Configuration config;

    @SidedProxy(serverSide = Constants.Proxy.COMMON, clientSide = Constants.Proxy.CLIENT)
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        config = new Configuration(event.getSuggestedConfigurationFile());
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);
    }
}
