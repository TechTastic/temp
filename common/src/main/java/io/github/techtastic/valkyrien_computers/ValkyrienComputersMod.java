package io.github.techtastic.valkyrien_computers;

import dev.architectury.platform.Platform;
import dev.architectury.registry.client.rendering.BlockEntityRendererRegistry;
import io.github.techtastic.valkyrien_computers.block.ValkyrienComputersBlockEntities;
import io.github.techtastic.valkyrien_computers.block.ValkyrienComputersBlocks;
import io.github.techtastic.valkyrien_computers.block.entity.renderer.GyroscopicSensorBlockEntityRenderer;
import io.github.techtastic.valkyrien_computers.integration.cc.ValkyrienComputersPeripheralProviders;
import io.github.techtastic.valkyrien_computers.item.ValkyrienComputersItems;

public class ValkyrienComputersMod {
    public static final String MOD_ID = "valkyrien_computers";
    
    public static void init() {
        ValkyrienComputersItems.register();
        ValkyrienComputersBlocks.register();
        ValkyrienComputersBlockEntities.register();

        if (Platform.isModLoaded("computercraft"))
            ValkyrienComputersPeripheralProviders.registerPeripheralProviders();
    }

    public static void initClient() {
        ValkyrienComputersPartials.init();

        BlockEntityRendererRegistry.register(ValkyrienComputersBlockEntities.GYROSCOPIC_SENSOR_BLOCK_ENTITY.get(), GyroscopicSensorBlockEntityRenderer::new);
    }
}
