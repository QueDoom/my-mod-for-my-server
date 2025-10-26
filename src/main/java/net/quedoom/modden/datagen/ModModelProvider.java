package net.quedoom.modden.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.quedoom.modden.block.ModBlocks;
import net.quedoom.modden.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TEST_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FERRUGINOUS_AMETHYST_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RAW_FERRUGINOUS_AMETHYST, Models.GENERATED);
        itemModelGenerator.register(ModItems.FERRUGINOUS_AMETHYST, Models.GENERATED);

        itemModelGenerator.register(ModItems.THE_ORB, Models.GENERATED);
        itemModelGenerator.register(ModItems.THE_AETHER_SHEARS, Models.GENERATED);
        itemModelGenerator.register(ModItems.SOUL, Models.GENERATED);

        itemModelGenerator.register(ModItems.ETHERIAL_GUMMY, Models.GENERATED);

        itemModelGenerator.register(ModItems.NETHERITE_CHUNK, Models.GENERATED);

    }
}
