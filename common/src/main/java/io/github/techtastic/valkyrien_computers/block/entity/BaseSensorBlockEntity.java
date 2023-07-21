package io.github.techtastic.valkyrien_computers.block.entity;

import io.github.techtastic.valkyrien_computers.block.ValkyrienComputersBlockEntities;
import io.github.techtastic.valkyrien_computers.integration.cc.ComputerCraftAttachmentHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class BaseSensorBlockEntity extends BlockEntity {
    public final ComputerCraftAttachmentHandler ccHandler = new ComputerCraftAttachmentHandler();

    public BaseSensorBlockEntity(BlockEntityType<? extends BaseSensorBlockEntity> type, BlockPos blockPos, BlockState blockState) {
        super(type, blockPos, blockState);
    }

    public static <E extends BlockEntity> void tick(Level level, BlockPos blockPos, BlockState blockState, BaseSensorBlockEntity entity) {
        entity.trueTick(level, blockPos, blockState, entity);
    }

    public void trueTick(Level level, BlockPos blockPos, BlockState blockState, BaseSensorBlockEntity entity) {}
}
