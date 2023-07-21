package io.github.techtastic.valkyrien_computers.fabric;

import io.github.techtastic.valkyrien_computers.ValkyrienComputersMod;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.ModInitializer;

public class ValkyrienComputersModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        ValkyrienComputersMod.init();
    }

    @Environment(EnvType.CLIENT)
    public static class Client implements ClientModInitializer {

        @Override
        public void onInitializeClient() {
            ValkyrienComputersMod.initClient();
        }
    }
}
