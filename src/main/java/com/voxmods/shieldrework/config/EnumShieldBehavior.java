package com.voxmods.shieldrework.config;

public enum EnumShieldBehavior {
    LOWER_WHEN_HOLDING_BLOCK(0),
    LOWER_ALWAYS(1);

    public static final EnumShieldBehavior DEFAULT = LOWER_WHEN_HOLDING_BLOCK;

    private int value;

    EnumShieldBehavior(int value) {
        this.value = value;
    }

    public int getInt() {
        return value;
    }

    public static EnumShieldBehavior fromInt(int i) {
        for (EnumShieldBehavior b : EnumShieldBehavior.values()) {
            if (b.getInt() == i) { return b; }
        }
        return null;
    }
}
