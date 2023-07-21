package io.github.techtastic.valkyrien_computers.block.entity.renderer;

import com.jozufozu.flywheel.core.model.ModelUtil;
import com.jozufozu.flywheel.core.model.ShadeSeparatedBufferedData;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Quaternion;
import io.github.techtastic.valkyrien_computers.ValkyrienComputersPartials;
import io.github.techtastic.valkyrien_computers.block.entity.GyroscopicSensorBlockEntity;
import io.github.techtastic.valkyrien_computers.util.ShipIntegrationMethods;
import io.github.techtastic.valkyrien_computers.util.rendering.SuperByteBuffer;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaterniond;
import org.joml.Quaterniondc;
import org.joml.Vector3d;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

public class GyroscopicSensorBlockEntityRenderer implements BlockEntityRenderer<GyroscopicSensorBlockEntity> {
    public GyroscopicSensorBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    public void render(@NotNull GyroscopicSensorBlockEntity gyro, float f, @NotNull PoseStack ps, @NotNull MultiBufferSource buffer, int i, int j) {
        ClientLevel level = (ClientLevel) gyro.getLevel();
        BlockPos pos = gyro.getBlockPos();
        BlockState state = gyro.getBlockState();
        VertexConsumer vb = buffer.getBuffer(RenderType.translucent());

        // Put Rings and Core Partials here
        SuperByteBuffer core = standardModelRender(ValkyrienComputersPartials.GYRO_CORE.get(), state).light(i);
        SuperByteBuffer inner = standardModelRender(ValkyrienComputersPartials.GYRO_INNER.get(), state).light(i);
        SuperByteBuffer middle = standardModelRender(ValkyrienComputersPartials.GYRP_MIDDLE.get(), state).light(i);
        SuperByteBuffer outer = standardModelRender(ValkyrienComputersPartials.GYRO_OUTER.get(), state).light(i);

        ClientShip ship = VSGameUtilsKt.getShipObjectManagingPos(level, pos);
        if (ship == null)
            renderConstantRotation(ps, vb, core, inner, middle, outer);
        else
            renderShipRotation(ps, vb, core, inner, middle, outer, ship.getTransform().getShipToWorldRotation());
    }

    public void renderConstantRotation(PoseStack ps, VertexConsumer vb, SuperByteBuffer core,
                                       SuperByteBuffer inner, SuperByteBuffer middle, SuperByteBuffer outer) {
        core.renderInto(ps, vb);
    }

    public void renderShipRotation(PoseStack ps, VertexConsumer vb, SuperByteBuffer core,
                                   SuperByteBuffer inner, SuperByteBuffer middle, SuperByteBuffer outer, Quaterniondc quaternion) {
        Quaterniond inverse = quaternion.conjugate(new Quaterniond());
        Quaternion conjugate = new Quaternion((float) inverse.x(), (float) inverse.y(), (float) inverse.z(), (float) inverse.w());
        Vector3d rpy = ShipIntegrationMethods.convertQuaternionToRPY(inverse);

        core.rotateCentered(conjugate).renderInto(ps, vb);
        outer.rotateXRadians(rpy.x).renderInto(ps, vb);
        middle.rotateYRadians(rpy.y).renderInto(ps, vb);
        inner.rotateZRadians(rpy.z).renderInto(ps, vb);
    }

    public static SuperByteBuffer standardModelRender(BakedModel model, BlockState referenceState) {
        ShadeSeparatedBufferedData data = ModelUtil.getBufferedData(model, referenceState, new PoseStack());
        SuperByteBuffer sbb = new SuperByteBuffer(data);
        data.release();
        return sbb;
    }
}
