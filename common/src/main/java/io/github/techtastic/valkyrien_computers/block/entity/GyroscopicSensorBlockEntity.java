package io.github.techtastic.valkyrien_computers.block.entity;

import io.github.techtastic.valkyrien_computers.block.ValkyrienComputersBlockEntities;
import io.github.techtastic.valkyrien_computers.util.ShipIntegrationMethods;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.joml.Quaterniond;
import org.joml.Quaterniondc;
import org.joml.Vector3d;
import org.valkyrienskies.core.api.ships.ServerShip;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

import java.util.Map;

public class GyroscopicSensorBlockEntity extends BaseSensorBlockEntity {
    private Quaterniondc prevQuaternion = null;
    private double testAngle = Math.toRadians(5.0);

    public GyroscopicSensorBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ValkyrienComputersBlockEntities.GYROSCOPIC_SENSOR_BLOCK_ENTITY.get(), blockPos, blockState);
    }

    @Override
    public void trueTick(Level level, BlockPos blockPos, BlockState blockState, BaseSensorBlockEntity entity) {
        super.trueTick(level, blockPos, blockState, entity);

        if (level.isClientSide)
            return;
        ServerShip ship = VSGameUtilsKt.getShipManagingPos((ServerLevel) level, blockPos);
        if (ship == null)
            return;

        Quaterniondc current = ship.getTransform().getShipToWorldRotation();

        Vector3d currentRPY = ShipIntegrationMethods.convertQuaternionToRPY(current);
        Vector3d previousRPY = ShipIntegrationMethods.convertQuaternionToRPY(this.prevQuaternion);

        if (currentRPY.x > previousRPY.x + testAngle || currentRPY.x < previousRPY.x - testAngle ||
                currentRPY.y > previousRPY.y + testAngle || currentRPY.y < previousRPY.y - testAngle ||
                currentRPY.z > previousRPY.z + testAngle || currentRPY.z < previousRPY.z - testAngle) {
            this.ccHandler.sendEvent("rotation", ShipIntegrationMethods.getRotationAsQuaternion(ship));
            this.prevQuaternion = current;
        }

        this.setChanged();
    }

    @Override
    protected void saveAdditional(CompoundTag compoundTag) {
        compoundTag.putDouble("ValkyrienComputers$rotX", this.prevQuaternion.x());
        compoundTag.putDouble("ValkyrienComputers$rotY", this.prevQuaternion.y());
        compoundTag.putDouble("ValkyrienComputers$rotZ", this.prevQuaternion.z());
        compoundTag.putDouble("ValkyrienComputers$rotW", this.prevQuaternion.w());

        compoundTag.putDouble("ValkyrienComputers$testAngle", this.testAngle);

        super.saveAdditional(compoundTag);
    }

    @Override
    public void load(CompoundTag compoundTag) {
        super.load(compoundTag);

        this.prevQuaternion = new Quaterniond(
                compoundTag.getDouble("ValkyrienComputers$rotX"),
                compoundTag.getDouble("ValkyrienComputers$rotY"),
                compoundTag.getDouble("ValkyrienComputers$rotZ"),
                compoundTag.getDouble("ValkyrienComputers$rotW")
        );

        this.testAngle = compoundTag.getDouble("ValkyrienComputers$testAngle");
    }

    public double getTestAngle() {
        return this.testAngle;
    }

    public void setTestAngle(double angle) {
        this.testAngle = angle;
    }
}
