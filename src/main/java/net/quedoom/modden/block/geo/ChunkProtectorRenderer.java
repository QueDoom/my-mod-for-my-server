package net.quedoom.modden.block.geo;

import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.render.entity.EntityRenderer;
import net.quedoom.modden.block.entity.custom.ChunkProtectorBlockEntity;
import net.quedoom.modden.geomodels.ChunkProtectorGeoModel;
import software.bernie.geckolib.model.DefaultedBlockGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class ChunkProtectorRenderer extends GeoBlockRenderer<ChunkProtectorBlockEntity> {
    public ChunkProtectorRenderer(DefaultedBlockGeoModel<ChunkProtectorBlockEntity> model) {
        super(new ChunkProtectorGeoModel());
    }
}
