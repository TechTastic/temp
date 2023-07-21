package io.github.techtastic.valkyrien_computers;

import dan200.computercraft.api.peripheral.IPeripheralProvider;
import dev.architectury.injectables.annotations.ExpectPlatform;
import dev.architectury.platform.Platform;

import java.nio.file.Path;

public class ValkyrienComputersExpectPlatform {
    /**
     * We can use {@link Platform#getConfigFolder()} but this is just an example of {@link ExpectPlatform}.
     * <p>
     * This must be a <b>public static</b> method. The platform-implemented solution must be placed under a
     * platform sub-package, with its class suffixed with {@code Impl}.
     * <p>
     * Example:
     * Expect: io.github.techtastic.valkyrien_computers.ValkyrienComputersExpectPlatform#getConfigDirectory()
     * Actual Fabric: net.valkyrien_computers.fabric.ExampleExpectPlatformImpl#getConfigDirectory()
     * Actual Forge: net.valkyrien_computers.forge.ExampleExpectPlatformImpl#getConfigDirectory()
     * <p>
     * <a href="https://plugins.jetbrains.com/plugin/16210-architectury">You should also get the IntelliJ plugin to help with @ExpectPlatform.</a>
     */
    @ExpectPlatform
    public static Path getConfigDirectory() {
        // Just throw an error, the content should get replaced at runtime.
        throw new AssertionError();
    }

    @ExpectPlatform
    public static IPeripheralProvider getNewPeripheralProvider() {
        throw new AssertionError();
    }
}
