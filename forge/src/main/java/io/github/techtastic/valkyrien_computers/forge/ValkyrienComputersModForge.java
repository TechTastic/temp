package io.github.techtastic.valkyrien_computers.forge;

import dev.architectury.platform.forge.EventBuses;
import io.github.techtastic.valkyrien_computers.ValkyrienComputersMod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ValkyrienComputersMod.MOD_ID)
public class ValkyrienComputersModForge {
    public ValkyrienComputersModForge() {
        // Submit our event bus to let architectury register our content on the right time
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        EventBuses.registerModEventBus(ValkyrienComputersMod.MOD_ID, bus);
        bus.addListener(this::clientSetup);

        ValkyrienComputersMod.init();
    }

    void clientSetup(final FMLClientSetupEvent event) {
        ValkyrienComputersMod.initClient();
    }
}
