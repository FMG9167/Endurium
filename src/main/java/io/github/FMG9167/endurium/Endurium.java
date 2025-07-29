package io.github.FMG9167.endurium;

import net.fabricmc.api.ModInitializer;

public class Endurium implements ModInitializer {

    public static final String MOD_ID = "endurium";

    @Override
    public void onInitialize() {
        ModItems.initialize();
    }
}
