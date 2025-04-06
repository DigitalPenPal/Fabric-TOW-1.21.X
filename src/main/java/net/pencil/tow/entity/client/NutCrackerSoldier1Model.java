package net.pencil.tow.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.pencil.tow.Tow;
import net.pencil.tow.entity.custom.NutcrackerSoldier1Entity;

public class NutCrackerSoldier1Model<T extends NutcrackerSoldier1Entity> extends SinglePartEntityModel<T> {

    public static final EntityModelLayer NUTCRACKER_SOLDIER1 = new EntityModelLayer(Identifier.of
            (Tow.MOD_ID, "soldier"), "main");

        private final ModelPart soldier;
        private final ModelPart head;

        public NutCrackerSoldier1Model(ModelPart root) {
            this.soldier = root.getChild("soldier");
            this.head = this.soldier.getChild("head");

        }
        public static TexturedModelData getTexturedModelData() {
            ModelData modelData = new ModelData();
            ModelPartData modelPartData = modelData.getRoot();
            ModelPartData soldier = modelPartData.addChild("soldier", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

            ModelPartData head = soldier.addChild("head", ModelPartBuilder.create().uv(64, 0).cuboid(-8.0F, -21.5F, -8.0F, 16.0F, 8.0F, 16.0F, new Dilation(-0.5F))
                    .uv(72, 83).cuboid(-2.0F, -19.5F, -13.0F, 4.0F, 4.0F, 6.0F, new Dilation(-0.5F)), ModelTransform.pivot(0.0F, -12.0F, 0.0F));

            ModelPartData hat = head.addChild("hat", ModelPartBuilder.create().uv(0, 32).cuboid(-8.0F, -11.0F, -8.0F, 16.0F, 16.0F, 16.0F, new Dilation(0.0F))
                    .uv(0, 64).cuboid(-9.0F, 4.0F, -9.0F, 18.0F, 2.0F, 18.0F, new Dilation(0.01F)), ModelTransform.pivot(0.0F, -26.25F, 0.0F));

            ModelPartData body = soldier.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-8.0F, -14.0F, -8.0F, 16.0F, 16.0F, 16.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -12.0F, 0.0F));

            ModelPartData legs = soldier.addChild("legs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

            ModelPartData legR = legs.addChild("legR", ModelPartBuilder.create().uv(64, 24).cuboid(-3.0F, -2.0F, -3.0F, 6.0F, 10.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, -8.0F, 0.0F));

            ModelPartData legL = legs.addChild("legL", ModelPartBuilder.create().uv(64, 24).mirrored().cuboid(-3.0F, -2.0F, -3.0F, 6.0F, 10.0F, 6.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(4.0F, -8.0F, 0.0F));

            ModelPartData ams = soldier.addChild("ams", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -24.0F, 0.0F));

            ModelPartData armR = ams.addChild("armR", ModelPartBuilder.create().uv(64, 40).cuboid(-1.6767F, 1.5F, -3.0F, 4.0F, 14.0F, 6.0F, new Dilation(0.0F))
                    .uv(72, 60).cuboid(-2.6767F, -2.5F, -4.0F, 6.0F, 4.0F, 8.0F, new Dilation(0.0F))
                    .uv(72, 72).cuboid(-2.6767F, 1.5F, -4.0F, 6.0F, 3.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(-11.3333F, 0.5F, 0.0F));

            ModelPartData cutlass = armR.addChild("cutlass", ModelPartBuilder.create().uv(16, 84).cuboid(-1.0F, 1.25F, -3.0F, 1.0F, 2.0F, 3.0F, new Dilation(0.01F))
                    .uv(30, 88).cuboid(-1.0F, -4.75F, -1.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.01F))
                    .uv(88, 32).cuboid(-1.0F, -1.75F, 2.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.01F))
                    .uv(0, 84).cuboid(-1.0F, -0.75F, 0.0F, 1.0F, 3.0F, 3.0F, new Dilation(0.01F))
                    .uv(64, 60).cuboid(-1.0F, 1.25F, 2.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
                    .uv(8, 84).cuboid(-1.0F, -4.75F, -4.0F, 1.0F, 3.0F, 3.0F, new Dilation(0.0F))
                    .uv(30, 84).cuboid(-1.0F, 0.25F, -4.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.01F))
                    .uv(24, 84).cuboid(-1.0F, -1.75F, -5.0F, 1.0F, 3.0F, 2.0F, new Dilation(0.0F))
                    .uv(36, 84).cuboid(-1.0F, -1.75F, -1.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
                    .uv(84, 40).cuboid(-1.0F, -2.75F, -2.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.01F))
                    .uv(42, 84).cuboid(-1.0F, -5.75F, -5.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.01F))
                    .uv(84, 44).cuboid(-1.0F, -6.75F, -6.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
                    .uv(48, 84).cuboid(-1.0F, -7.75F, -7.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.01F))
                    .uv(84, 48).cuboid(-1.0F, -8.75F, -8.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
                    .uv(84, 52).cuboid(-1.0F, -9.75F, -9.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.01F))
                    .uv(54, 84).cuboid(-1.0F, -10.75F, -10.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
                    .uv(84, 56).cuboid(-1.0F, -11.75F, -11.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.01F))
                    .uv(60, 84).cuboid(-1.0F, -12.75F, -12.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
                    .uv(66, 84).cuboid(-1.0F, -13.75F, -13.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.01F))
                    .uv(88, 24).cuboid(-1.0F, -14.75F, -14.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
                    .uv(88, 28).cuboid(-1.0F, -15.75F, -15.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.01F))
                    .uv(34, 88).cuboid(-1.0F, -16.75F, -15.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.3333F, 14.5F, 0.0F, 0.7854F, 0.0F, 0.0F));

            ModelPartData armL = ams.addChild("armL", ModelPartBuilder.create().uv(64, 40).mirrored().cuboid(-2.3233F, 1.5F, -3.0F, 4.0F, 14.0F, 6.0F, new Dilation(0.0F)).mirrored(false)
                    .uv(72, 60).mirrored().cuboid(-3.3233F, -2.5F, -4.0F, 6.0F, 4.0F, 8.0F, new Dilation(0.0F)).mirrored(false)
                    .uv(72, 72).mirrored().cuboid(-3.3233F, 1.5F, -4.0F, 6.0F, 3.0F, 8.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(11.3333F, 0.5F, 0.0F));
            return TexturedModelData.of(modelData, 128, 128);
        }

        private void setHeadAngles(float headYaw, float headPitch) {
            headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
            headPitch = MathHelper.clamp(headPitch, -5.0F, 5.0F);

            this.head.yaw = headYaw * 0.01F;
            this.head.pitch = headPitch * 0F;
        }

        @Override
        public void setAngles(NutcrackerSoldier1Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
            this.getPart().traverse().forEach(ModelPart::resetTransform);
            this.setHeadAngles(netHeadYaw, headPitch);

            this.animateMovement(NutCrackerSoldier1Animations.SOLDER1_WALK, limbSwing, limbSwingAmount, 1F, 1.2F);
            this.updateAnimation(entity.idleAnimationState, NutCrackerSoldier1Animations.SOLDIER1_IDLE, ageInTicks, 1F);
        }

        @Override
        public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
            soldier.render(matrices, vertexConsumer, light, overlay, color);
        }

    @Override
    public ModelPart getPart() {
            return soldier;
    }
}
