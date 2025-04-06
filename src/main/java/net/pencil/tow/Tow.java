package net.pencil.tow;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.pencil.tow.entity.MoEntities;
import net.pencil.tow.entity.custom.NutcrackerSoldier1Entity;
import net.pencil.tow.item.MoItemGroups;
import net.pencil.tow.item.MoItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tow implements ModInitializer {
	public static final String MOD_ID = "tow";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");

		MoEntities.registerMoEntities();
		MoItems.registerMoItems();
		MoItemGroups.registerItemGroups();

		FabricDefaultAttributeRegistry.register(MoEntities.NUTCRACKER_SOLDIER_1, NutcrackerSoldier1Entity.createAttributes());
	}
}