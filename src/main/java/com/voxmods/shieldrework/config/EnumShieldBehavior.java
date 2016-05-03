package com.voxmods.shieldrework.config;

public enum EnumShieldBehavior {
    LOWER_ALWAYS(0),
    LOWER_WHEN_HOLDING_BLOCK(1);

    public static final EnumShieldBehavior DEFAULT = LOWER_ALWAYS;

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
