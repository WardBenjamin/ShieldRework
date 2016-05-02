package com.voxmods.lessintrusiveshields;

import com.voxmods.lessintrusiveshields.proxy.CommonProxy;
import com.voxmods.lessintrusiveshields.util.Constants;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = Constants.Mod.MOD_ID, name = Constants.Mod.MOD_NAME,
        version = Constants.Mod.VERSION, dependencies = Constants.Mod.DEPENDENCIES)
public class LessIntrusiveShields {

    @SidedProxy(serverSide = Constants.Proxy.COMMON, clientSide = Constants.Proxy.CLIENT)
    public CommonProxy proxy;

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    }
}
