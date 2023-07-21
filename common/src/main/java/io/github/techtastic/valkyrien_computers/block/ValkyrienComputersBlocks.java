package io.github.techtastic.valkyrien_computers.block;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import io.github.techtastic.valkyrien_computers.ValkyrienComputersMod;
import io.github.techtastic.valkyrien_computers.item.ValkyrienComputersItems;
import net.minecraft.core.Registry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

public class ValkyrienComputersBlocks {
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ValkyrienComputersMod.MOD_ID, Registry.BLOCK_REGISTRY);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ValkyrienComputersMod.MOD_ID, Registry.ITEM_REGISTRY);

    public static final RegistrySupplier<Block> GYROSCOPIC_SENSOR_BLOCK =
            BLOCKS.register("gyro", () -> new Block(BlockBehaviour.Properties.of(Material.METAL)));

    public static void register() {
        BLOCKS.register();

        for (RegistrySupplier<Block> block : BLOCKS) {
            ITEMS.register(block.getId(), () -> new BlockItem(block.get(), new Item.Properties().tab(ValkyrienComputersItems.TAB)));
        }

        ITEMS.register();
    }
}
