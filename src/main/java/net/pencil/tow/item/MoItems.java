package net.pencil.tow.item;


import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.pencil.tow.Tow;
import net.pencil.tow.entity.MoEntities;

public class MoItems {

    public static final Item NUTCRACKER_SOLDIER_BOX = registerItem("nutcracker_soldier_box",
            new SpawnEggItem(MoEntities.NUTCRACKER_SOLDIER_1, 0, 0, new Item.Settings()));

    private static Item registerItem(String name, Item item) {

        return Registry.register(Registries.ITEM, Identifier.of(Tow.MOD_ID, name), item);
    }

    public static void registerMoItems() {
        Tow.LOGGER.info("Registering Mod Items for " + Tow.MOD_ID);
    }
}
