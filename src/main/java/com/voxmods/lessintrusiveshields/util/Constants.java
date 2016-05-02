package com.voxmods.lessintrusiveshields.util;

public class Constants {
    public static class Mod {

        // Mod Constants
        public static final String MOD_ID = "LessIntrusiveShields";
        public static final String MOD_NAME = MOD_ID;
        public static final String VERSION = "@VERSION@" + "-MC" + "@MCVERSION@";
        public static final String DEPENDENCIES = "required-after:Forge@[12.16.0.1865,);";
        public static final String MOD_PREFIX = MOD_ID.toLowerCase() + ":";
    }

    public static class Proxy {
        // Proxy Constants
        public static final String COMMON = "com.voxmods.lessintrusiveshields.proxy.CommonProxy";
        public static final String CLIENT = "com.voxmods.lessintrusiveshields.proxy.ClientProxy";
    }
}
