package io.github.techtastic.valkyrien_computers.forge;

import dan200.computercraft.api.peripheral.IPeripheralProvider;
import io.github.techtastic.valkyrien_computers.ValkyrienComputersExpectPlatform;
import io.github.techtastic.valkyrien_computers.forge.integration.cc.ValkyrienComputersForgePeripheralProvider;
import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Path;

public class ValkyrienComputersExpectPlatformImpl {
    /**
     * This is our actual method to {@link ValkyrienComputersExpectPlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FMLPaths.CONFIGDIR.get();
    }

    public static IPeripheralProvider getNewPeripheralProvider() {
        return new ValkyrienComputersForgePeripheralProvider();
    }
}
