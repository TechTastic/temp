package io.github.techtastic.valkyrien_computers.forge.integration.cc;

import dan200.computercraft.api.peripheral.IPeripheral;
import dan200.computercraft.api.peripheral.IPeripheralProvider;
import io.github.techtastic.valkyrien_computers.block.entity.GyroscopicSensorBlockEntity;
import io.github.techtastic.valkyrien_computers.integration.cc.peripheral.GyroscopicSensorPeripheral;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;

public class ValkyrienComputersForgePeripheralProvider implements IPeripheralProvider {
    @NotNull
    @Override
    public LazyOptional<IPeripheral> getPeripheral(@NotNull Level level, @NotNull BlockPos blockPos, @NotNull Direction direction) {
        BlockEntity be = level.getBlockEntity(blockPos);
        if (be instanceof GyroscopicSensorBlockEntity gyro)
            return LazyOptional.of(() -> new GyroscopicSensorPeripheral(gyro));
        return LazyOptional.empty();
    }
}
