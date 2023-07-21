package io.github.techtastic.valkyrien_computers.fabric.integration.cc;

import dan200.computercraft.api.ComputerCraftAPI;
import dan200.computercraft.api.peripheral.IPeripheral;
import dan200.computercraft.api.peripheral.IPeripheralProvider;
import io.github.techtastic.valkyrien_computers.block.entity.GyroscopicSensorBlockEntity;
import io.github.techtastic.valkyrien_computers.integration.cc.peripheral.GyroscopicSensorPeripheral;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ValkyrienComputersFabricPeripheralProivder implements IPeripheralProvider {
    @Nullable
    @Override
    public IPeripheral getPeripheral(@NotNull Level level, @NotNull BlockPos blockPos, @NotNull Direction direction) {
        BlockEntity be = level.getBlockEntity(blockPos);
        if (be instanceof GyroscopicSensorBlockEntity gyro)
            return new GyroscopicSensorPeripheral(gyro);
        return null;
    }
}
