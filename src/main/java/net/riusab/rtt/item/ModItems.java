package net.riusab.rtt.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.riusab.rtt.RiusabsTimeTravel;

public class ModItems {
    public static final Item RAW_ENTROPY = registerItem("raw_entropy", new Item(new Item.Settings()));
    public static final Item UNCHARGED_ENTROPY = registerItem("uncharged_entropy", new Item(new Item.Settings()));
    public static final Item CHARGED_ENTROPY = registerItem("charged_entropy", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(RiusabsTimeTravel.MOD_ID, name), item);
    }

    public static void registerModItems() {
        RiusabsTimeTravel.LOGGER.info("Registering Mod Items: " + RiusabsTimeTravel.MOD_ID);

        // Add to creative items tab
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(RAW_ENTROPY);
            entries.add(UNCHARGED_ENTROPY);
            entries.add(CHARGED_ENTROPY);
        });
    }
}
