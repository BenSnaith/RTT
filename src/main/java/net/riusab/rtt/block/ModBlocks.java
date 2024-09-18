package net.riusab.rtt.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.riusab.rtt.RiusabsTimeTravel;

public class ModBlocks {
    public static final Block UNCHARGED_ENTROPY_BLOCK = registerBlock("uncharged_entropy_block",
            new Block(AbstractBlock.Settings.create()
                        .strength(4f)
                        .requiresTool()
                        .sounds(BlockSoundGroup.SCULK)));

    public static final Block CHARGED_ENTROPY_BLOCK = registerBlock("charged_entropy_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(5f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.SCULK)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(RiusabsTimeTravel.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(RiusabsTimeTravel.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        RiusabsTimeTravel.LOGGER.info("Registering Mod Blocks: " + RiusabsTimeTravel.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(ModBlocks.UNCHARGED_ENTROPY_BLOCK);
            entries.add(ModBlocks.CHARGED_ENTROPY_BLOCK);
        });
    }
}
