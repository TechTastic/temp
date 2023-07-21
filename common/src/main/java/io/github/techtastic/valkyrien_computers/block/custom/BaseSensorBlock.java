package io.github.techtastic.valkyrien_computers.block.custom;

import io.github.techtastic.valkyrien_computers.block.ValkyrienComputersBlockEntities;
import io.github.techtastic.valkyrien_computers.block.entity.BaseSensorBlockEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class BaseSensorBlock extends BaseEntityBlock {
    private BlockEntityType<? extends BaseSensorBlockEntity> type;

    public BaseSensorBlock(BlockEntityType<? extends BaseSensorBlockEntity> type, Properties properties) {
        super(properties);
        this.type = type;
    }

    @Override
    public RenderShape getRenderShape(BlockState blockState) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull Level level, @NotNull BlockState blockState, @NotNull BlockEntityType<T> blockEntityType) {
        return createTickerHelper(blockEntityType, this.type, BaseSensorBlockEntity::tick);
    }
}
