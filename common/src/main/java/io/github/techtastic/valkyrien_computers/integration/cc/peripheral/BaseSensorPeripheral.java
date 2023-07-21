package io.github.techtastic.valkyrien_computers.integration.cc.peripheral;

import dan200.computercraft.api.peripheral.IComputerAccess;
import dan200.computercraft.api.peripheral.IPeripheral;
import io.github.techtastic.valkyrien_computers.block.entity.BaseSensorBlockEntity;
import org.jetbrains.annotations.NotNull;

public abstract class BaseSensorPeripheral implements IPeripheral {
    public final BaseSensorBlockEntity sensor;

    public BaseSensorPeripheral(BaseSensorBlockEntity sensor) {
        this.sensor = sensor;
    }

    @Override
    public void attach(@NotNull IComputerAccess computer) {
        IPeripheral.super.attach(computer);

        this.sensor.ccHandler.attachComputer(computer);
    }

    @Override
    public void detach(@NotNull IComputerAccess computer) {
        IPeripheral.super.detach(computer);

        this.sensor.ccHandler.detachComputer(computer);
    }
}
