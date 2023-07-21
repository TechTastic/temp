package io.github.techtastic.valkyrien_computers.item;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import io.github.techtastic.valkyrien_computers.ValkyrienComputersMod;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ValkyrienComputersItems {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ValkyrienComputersMod.MOD_ID, Registry.ITEM_REGISTRY);

    private static final RegistrySupplier<Item> LOGO = ITEMS.register("logo", () -> new Item(new Item.Properties()));

    public static final CreativeModeTab TAB = CreativeTabRegistry.create(new ResourceLocation(ValkyrienComputersMod.MOD_ID, "tab"), () -> new ItemStack(LOGO.get()));

    public static void register() {
        ITEMS.register();
    }
}
