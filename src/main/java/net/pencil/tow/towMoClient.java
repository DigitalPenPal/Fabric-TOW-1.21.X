package net.pencil.tow;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.pencil.tow.entity.MoEntities;
import net.pencil.tow.entity.client.NutCrackerSoldier1Model;
import net.pencil.tow.entity.client.NutCrackerSoldier1Renderer;

public class towMoClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        EntityModelLayerRegistry.registerModelLayer(NutCrackerSoldier1Model.NUTCRACKER_SOLDIER1,
                NutCrackerSoldier1Model::getTexturedModelData);

        EntityRendererRegistry.register(MoEntities.NUTCRACKER_SOLDIER_1, NutCrackerSoldier1Renderer::new);
    }
}
