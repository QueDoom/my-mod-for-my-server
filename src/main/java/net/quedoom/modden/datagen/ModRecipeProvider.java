package net.quedoom.modden.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.quedoom.modden.ModTillServer;
import net.quedoom.modden.block.ModBlocks;
import net.quedoom.modden.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {

        List<ItemConvertible> FERRUGINOUS_AMETHYST_SMELTABLES = List.of(ModItems.RAW_FERRUGINOUS_AMETHYST);
        offerSmelting(recipeExporter, FERRUGINOUS_AMETHYST_SMELTABLES, RecipeCategory.MISC, ModItems.FERRUGINOUS_AMETHYST, 0.2f, 200, "ferruginous_amethyst");
        offerBlasting(recipeExporter, FERRUGINOUS_AMETHYST_SMELTABLES, RecipeCategory.MISC, ModItems.FERRUGINOUS_AMETHYST, 0.25f, 100, "ferruginous_amethyst");

        offer2x2CompactingRecipe(recipeExporter, RecipeCategory.MISC, ModBlocks.FERRUGINOUS_AMETHYST_BLOCK, ModItems.FERRUGINOUS_AMETHYST);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.AETHER_PORTAL)
                .pattern("NSN")
                .pattern(" N ")
                .pattern("FFF")
                .input('N', ModItems.NETHERITE_CHUNK)
                .input('S', ModItems.SOUL)
                .input('F', ModBlocks.FERRUGINOUS_AMETHYST_BLOCK)
                .criterion(hasItem(ModItems.SOUL), conditionsFromItem(ModItems.SOUL))
                .offerTo(recipeExporter, Identifier.of(ModTillServer.MOD_ID, "chunk_protector"))
        ;

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.AETHER_PORTAL)
                .pattern("GGG")
                .pattern("GWG")
                .pattern("GGG")
                .input('G', Blocks.GLOWSTONE)
                .input('W', Items.WATER_BUCKET)
                .criterion(hasItem(Blocks.GLOWSTONE), conditionsFromItem(Blocks.GLOWSTONE))
                .offerTo(recipeExporter)
        ;

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.THE_AETHER_SHEARS)
                .pattern(" I ")
                .pattern(" FI")
                .pattern("A  ")
                .input('I', Items.IRON_INGOT)
                .input('F', ModItems.RAW_FERRUGINOUS_AMETHYST)
                .input('A', ModItems.AETHER_PORTAL)
                .criterion(hasItem(Blocks.GLOWSTONE), conditionsFromItem(Blocks.GLOWSTONE))
                .offerTo(recipeExporter)
        ;

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_FERRUGINOUS_AMETHYST, 1)
                .input(Items.AMETHYST_SHARD)
                .input(Items.IRON_INGOT)
                .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(recipeExporter, Identifier.of(ModTillServer.MOD_ID, "raw_ferruginous_amethyst"))
        ;
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.NETHERITE_INGOT, 1)
                .input(ModItems.NETHERITE_CHUNK)
                .input(ModItems.NETHERITE_CHUNK)
                .criterion(hasItem(ModItems.NETHERITE_CHUNK), conditionsFromItem(ModItems.NETHERITE_CHUNK))
                .offerTo(recipeExporter, Identifier.of(ModTillServer.MOD_ID, "netherite_ingot_from_netherite_chunks"))
        ;
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.NETHERITE_CHUNK, 2)
                .input(Items.NETHERITE_INGOT)
                .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                .group("netherite_ingot")
                .offerTo(recipeExporter, Identifier.of(ModTillServer.MOD_ID, "netherite_chunks_from_netherite_ingot"))
        ;
    }
}
