package net.quedoom.modden.geomodels;

import net.minecraft.util.Identifier;

import net.quedoom.modden.ModTillServer;

import net.quedoom.modden.block.entity.custom.ChunkProtectorBlockEntity;
import software.bernie.geckolib.model.DefaultedBlockGeoModel;

public class ChunkProtectorGeoModel extends DefaultedBlockGeoModel<ChunkProtectorBlockEntity> {
    private final Identifier model = Identifier.of(ModTillServer.MOD_ID, "geo/block/chunk_protector.geo.json");
    private final Identifier texture = Identifier.of(ModTillServer.MOD_ID, "textures/block/chunk_protector.png");
    private final Identifier animations = Identifier.of(ModTillServer.MOD_ID, "animations/block/chunk_protector.animation.json");

    public ChunkProtectorGeoModel() {
        super(Identifier.of(ModTillServer.MOD_ID, "chunk_protector"));
    }

    @Override
    public Identifier getAnimationResource(ChunkProtectorBlockEntity animatable) {
        return animations;
    }

    @Override
    public Identifier getTextureResource(ChunkProtectorBlockEntity animatable) {
        return texture;
    }

    @Override
    public Identifier getModelResource(ChunkProtectorBlockEntity animatable) {
        return model;
    }
}
