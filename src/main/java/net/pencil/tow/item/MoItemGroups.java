package net.pencil.tow.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.pencil.tow.Tow;

public class MoItemGroups {

    public static final ItemGroup TOYS_OF_WAR_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Tow.MOD_ID, "toys_of_war_items"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable("itemgroup.tow.toys_of_war_items"))
                    .entries((displayContext, entries) -> {

                        entries.add(MoItems.NUTCRACKER_SOLDIER_BOX);

                    })
                    .build());

    public static void registerItemGroups() {
        Tow.LOGGER.info("Registering Item Groups for " + Tow.MOD_ID);
    }
}
