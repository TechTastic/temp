package io.github.techtastic.valkyrien_computers.fabric;

import dan200.computercraft.api.peripheral.IPeripheralProvider;
import io.github.techtastic.valkyrien_computers.ValkyrienComputersExpectPlatform;
import io.github.techtastic.valkyrien_computers.fabric.integration.cc.ValkyrienComputersFabricPeripheralProivder;
import net.fabricmc.loader.api.FabricLoader;

import java.nio.file.Path;

public class ValkyrienComputersExpectPlatformImpl {
    /**
     * This is our actual method to {@link ValkyrienComputersExpectPlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FabricLoader.getInstance().getConfigDir();
    }

    public static IPeripheralProvider getNewPeripheralProvider() {
        return new ValkyrienComputersFabricPeripheralProivder();
    }
}
