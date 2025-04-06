package net.pencil.tow.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.pencil.tow.Tow;
import net.pencil.tow.entity.custom.NutcrackerSoldier1Entity;

public class MoEntities {

    public static final EntityType<NutcrackerSoldier1Entity> NUTCRACKER_SOLDIER_1 = Registry.register(
            Registries.ENTITY_TYPE, Identifier.of(Tow.MOD_ID, "nutcracker_soldier_1"),
            EntityType.Builder.create(NutcrackerSoldier1Entity::new, SpawnGroup.MISC)
                    .dimensions(1f, 2.5f).build());

    public static void registerMoEntities() {
        Tow.LOGGER.info("Registering Mod Entinties for " + Tow.MOD_ID);
    }
}
