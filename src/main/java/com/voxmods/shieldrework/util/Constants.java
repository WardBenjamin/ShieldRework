package com.voxmods.shieldrework.util;

public class Constants {
    public static class Mod {

        // Mod Constants
        public static final String MOD_ID = "ShieldRework";
        public static final String MOD_NAME = "Shield Rework";
        public static final String VERSION = "@VERSION@" + "-MC" + "@MCVERSION@";
        public static final String DEPENDENCIES = "required-after:Forge@[12.16.0.1865,);";
        public static final String DOMAIN = MOD_ID.toLowerCase();
        public static final String MOD_PREFIX = DOMAIN + ":";
    }

    public static class Proxy {
        // Proxy Constants
        public static final String COMMON = "com.voxmods.shieldrework.common.CommonProxy";
        public static final String CLIENT = "com.voxmods.shieldrework.client.ClientProxy";
    }

    public static class Plugin {
        // Plugin Constants
        public static final String JEI = "com.voxmods.shieldrework.plugin.JEIPlugin";
        public static final String TINKERSCONSTRUCT = "com.voxmods.shieldrework.plugin.TiConPlugin";
    }
}
