package io.github.techtastic.valkyrien_computers.block.custom;

import io.github.techtastic.valkyrien_computers.block.ValkyrienComputersBlockEntities;
import io.github.techtastic.valkyrien_computers.block.entity.GyroscopicSensorBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class GyroscopicSensorBlock extends BaseSensorBlock {
    public GyroscopicSensorBlock(Properties properties) {
        super(ValkyrienComputersBlockEntities.GYROSCOPIC_SENSOR_BLOCK_ENTITY.get(), properties);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new GyroscopicSensorBlockEntity(blockPos, blockState);
    }
}
