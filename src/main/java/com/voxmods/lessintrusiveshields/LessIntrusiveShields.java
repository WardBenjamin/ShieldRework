package com.voxmods.lessintrusiveshields;

import com.voxmods.lessintrusiveshields.proxy.CommonProxy;
import com.voxmods.lessintrusiveshields.util.Constants;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Constants.Mod.MOD_ID, name = Constants.Mod.MOD_NAME,
        version = Constants.Mod.VERSION, dependencies = Constants.Mod.DEPENDENCIES)
public class LessIntrusiveShields {

    @Mod.Instance
    public static LessIntrusiveShields instance;

    @SidedProxy(serverSide = Constants.Proxy.COMMON, clientSide = Constants.Proxy.CLIENT)
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
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
