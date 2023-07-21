package io.github.techtastic.valkyrien_computers.integration.cc.peripheral;

import dan200.computercraft.api.lua.IArguments;
import dan200.computercraft.api.lua.LuaException;
import dan200.computercraft.api.lua.LuaFunction;
import dan200.computercraft.api.lua.MethodResult;
import dan200.computercraft.api.peripheral.IPeripheral;
import io.github.techtastic.valkyrien_computers.block.entity.GyroscopicSensorBlockEntity;
import io.github.techtastic.valkyrien_computers.util.ShipIntegrationMethods;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.core.api.ships.ServerShip;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

import java.util.Map;

public class GyroscopicSensorPeripheral extends BaseSensorPeripheral {
    private final Level level;
    private final BlockPos pos;

    public GyroscopicSensorPeripheral(GyroscopicSensorBlockEntity sensor) {
        super(sensor);
        this.level = sensor.getLevel();
        this.pos = sensor.getBlockPos();
    }

    @Override
    public @NotNull String getType() {
        return "gyro";
    }

    @Override
    public boolean equals(IPeripheral iPeripheral) {
        return iPeripheral instanceof GyroscopicSensorPeripheral;
    }

    @LuaFunction
    public final MethodResult getRotation(IArguments arg) throws LuaException {
        if (level.isClientSide)
            return null;

        ServerShip ship = VSGameUtilsKt.getShipManagingPos((ServerLevel) level, pos);
        if (ship == null)
            return null;

        boolean bool = arg.optBoolean(0, false);

        Map<String, Double> quat = bool ? ShipIntegrationMethods.getRotationAsQuaternion(ship) :
                ShipIntegrationMethods.getRotationAsRPY(ship);

        return bool ? MethodResult.of(quat.get("x"), quat.get("y"), quat.get("z"), quat.get("w")) :
                MethodResult.of(quat.get("roll"), quat.get("pitch"), quat.get("yaw"));
    }

    @LuaFunction
    public final double getTestAngle() {
        return ((GyroscopicSensorBlockEntity) this.sensor).getTestAngle();
    }

    @LuaFunction
    public final void setTestAngle(double angle) {
        ((GyroscopicSensorBlockEntity) this.sensor).setTestAngle(angle);
    }
}
