package io.github.techtastic.valkyrien_computers.integration.cc;

import dan200.computercraft.api.ComputerCraftAPI;
import io.github.techtastic.valkyrien_computers.ValkyrienComputersExpectPlatform;

public class ValkyrienComputersPeripheralProviders {
    public static void registerPeripheralProviders() {
        ComputerCraftAPI.registerPeripheralProvider(ValkyrienComputersExpectPlatform.getNewPeripheralProvider());
    }
}
