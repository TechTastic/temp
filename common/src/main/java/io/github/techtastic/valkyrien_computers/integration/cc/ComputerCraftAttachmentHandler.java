package io.github.techtastic.valkyrien_computers.integration.cc;

import dan200.computercraft.api.peripheral.IComputerAccess;

import java.util.ArrayList;
import java.util.List;

public class ComputerCraftAttachmentHandler {
    private final List<IComputerAccess> accessList = new ArrayList<>();

    public void attachComputer(IComputerAccess access) {
        this.accessList.add(access);
    }

    public void detachComputer(IComputerAccess access) {
        this.accessList.remove(access);
    }

    public void sendEvent(String name, Object obj) {
        this.accessList.forEach(access -> access.queueEvent(name, obj));
    }
}
