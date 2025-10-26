package net.quedoom.modden.block;

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
import net.quedoom.modden.ModTillServer;
import net.quedoom.modden.block.custom.ChunkProtectorBlock;

public class ModBlocks {

    public static final Block TEST_BLOCK = registerBlock("test_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)
            ),false)
    ;
    public static final Block FERRUGINOUS_AMETHYST_BLOCK = registerBlock("ferruginous_amethyst_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(4f)
                    .resistance(3f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)
            ),false)
    ;
    public static final Block CHUNK_PROTECTOR = registerBlock("chunk_protector",
            new ChunkProtectorBlock(AbstractBlock.Settings.create()
                    .nonOpaque()
                    .strength(6.0f)
                    .resistance(9999.0f)
                    .sounds(BlockSoundGroup.NETHERITE)
    ), false    );

    private static Block registerBlock(String name, Block block, boolean isOnlyBlock) {
        if (!isOnlyBlock) {
            registerBlockItem(name, block);
        }
        return  Registry.register(Registries.BLOCK, Identifier.of(ModTillServer.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(ModTillServer.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        ModTillServer.LOGGER.info("Registering Blocks for" + ModTillServer.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.OPERATOR).register(entries -> {
            entries.add(ModBlocks.TEST_BLOCK);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(ModBlocks.FERRUGINOUS_AMETHYST_BLOCK);
        });
    }
}
