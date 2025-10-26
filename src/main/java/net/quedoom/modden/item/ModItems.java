package net.quedoom.modden.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.ZipCompressor;
import net.quedoom.modden.ModTillServer;
import net.quedoom.modden.block.ModBlocks;
import net.quedoom.modden.item.custom.AetherPortalItem;
import net.quedoom.modden.item.custom.EtherialGummyItem;
import net.quedoom.modden.item.custom.TheAetherShearsItem;

public class ModItems{

    public static final Item THE_ORB = registerItem("the_orb", new Item(new Item.Settings().maxCount(1)));
    public static final Item SOUL = registerItem("soul", new Item(new Item.Settings().maxCount(1)));
    public static final Item THE_AETHER_SHEARS = registerItem("the_aether_shears", new TheAetherShearsItem(new Item.Settings().maxDamage(1).maxCount(1)));
    public static final Item AETHER_PORTAL = registerItem("aether_portal", new AetherPortalItem(new Item.Settings()));

    // Ferruginous Amethyst
    public static final Item RAW_FERRUGINOUS_AMETHYST = registerItem("raw_ferruginous_amethyst", new Item(new Item.Settings()));
    public static final Item FERRUGINOUS_AMETHYST = registerItem("ferruginous_amethyst", new Item(new Item.Settings()));

    // "Vanilla"
    public static final Item NETHERITE_CHUNK = registerItem("netherite_chunk", new Item(new Item.Settings()));

    public static final Item ETHERIAL_GUMMY = registerItem("etherial_gummy", new EtherialGummyItem(new Item.Settings().food(ModFoodComponents.ETHERIAL_GUMMY).maxCount(1)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ModTillServer.MOD_ID, name), item);
    }



    public static void registerModItems() {
        ModTillServer.LOGGER.info("Registering Mod Items for " + ModTillServer.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.OPERATOR).register(entries -> {
            entries.add(ModItems.THE_ORB);
            entries.add(ModItems.SOUL);
            entries.add(ModItems.THE_AETHER_SHEARS);
            entries.add(ModItems.AETHER_PORTAL);
            entries.add(ModBlocks.CHUNK_PROTECTOR);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
           entries.add(ModItems.AETHER_PORTAL);
           entries.add(ModItems.RAW_FERRUGINOUS_AMETHYST);
           entries.add(ModItems.FERRUGINOUS_AMETHYST);
           entries.add(ModItems.NETHERITE_CHUNK);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(ModItems.ETHERIAL_GUMMY);
        });
    }
}
