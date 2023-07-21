package io.github.techtastic.valkyrien_computers;

import com.jozufozu.flywheel.core.PartialModel;
import net.minecraft.resources.ResourceLocation;

public class ValkyrienComputersPartials {
    public static final PartialModel
            GYRO_CORE = block("gyro/core"),
            GYRO_OUTER = block("gyro/outer"),
            GYRP_MIDDLE = block("gyro/middle"),
            GYRO_INNER = block("gyro/inner");

    private static PartialModel block(String path) {
        return new PartialModel(new ResourceLocation(ValkyrienComputersMod.MOD_ID, "block/" + path));
    }

    private static PartialModel entity(String path) {
        return new PartialModel(new ResourceLocation(ValkyrienComputersMod.MOD_ID, "entity/" + path));
    }



    private static PartialModel item(String path) {
        return new PartialModel(new ResourceLocation(ValkyrienComputersMod.MOD_ID, "item/" + path));
    }

    public static void init() {
        // init static fields
    }
}
