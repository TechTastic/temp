package io.github.techtastic.valkyrien_computers.block;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import io.github.techtastic.valkyrien_computers.ValkyrienComputersMod;
import io.github.techtastic.valkyrien_computers.block.entity.BaseSensorBlockEntity;
import io.github.techtastic.valkyrien_computers.block.entity.GyroscopicSensorBlockEntity;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class ValkyrienComputersBlockEntities {
    private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ValkyrienComputersMod.MOD_ID, Registry.BLOCK_ENTITY_TYPE_REGISTRY);

    public static final RegistrySupplier<BlockEntityType<GyroscopicSensorBlockEntity>> GYROSCOPIC_SENSOR_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("gyro_sensor", () ->
                    BlockEntityType.Builder.of(GyroscopicSensorBlockEntity::new,
                            ValkyrienComputersBlocks.GYROSCOPIC_SENSOR_BLOCK.get()
                    ).build(null));

    public static void register() {
        BLOCK_ENTITIES.register();
    }
}
