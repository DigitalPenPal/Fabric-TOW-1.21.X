package net.pencil.tow.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.pencil.tow.Tow;
import net.pencil.tow.entity.custom.NutcrackerSoldier1Entity;

public class NutCrackerSoldier1Renderer extends MobEntityRenderer<NutcrackerSoldier1Entity, NutCrackerSoldier1Model<NutcrackerSoldier1Entity>> {


    public NutCrackerSoldier1Renderer(EntityRendererFactory.Context context) {
        super(context, new NutCrackerSoldier1Model<>(context.getPart(NutCrackerSoldier1Model.NUTCRACKER_SOLDIER1)), 0.75f);
    }

    @Override
    public Identifier getTexture(NutcrackerSoldier1Entity entity) {
        return Identifier.of(Tow.MOD_ID, "textures/entity/nutcracker_soldier1/nutcracker_soldier1.png");
    }
}
