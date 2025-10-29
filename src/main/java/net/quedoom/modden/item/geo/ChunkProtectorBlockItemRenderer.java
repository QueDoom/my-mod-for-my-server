package net.quedoom.modden.item.geo;

import net.minecraft.util.Identifier;
import net.quedoom.modden.ModTillServer;
import net.quedoom.modden.block.custom.ChunkProtectorBlock;
import net.quedoom.modden.geomodels.ChunkProtectorGeoModel;
import net.quedoom.modden.item.custom.ChunkProtectorBlockItem;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class ChunkProtectorBlockItemRenderer extends GeoItemRenderer<ChunkProtectorBlockItem> {

    public ChunkProtectorBlockItemRenderer() {
        super(new DefaultedItemGeoModel<>(Identifier.of(ModTillServer.MOD_ID, "chunk_protector")));
    }
}
