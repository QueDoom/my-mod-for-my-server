package net.quedoom.modden;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.quedoom.modden.block.entity.ModBlockEntities;
import net.quedoom.modden.block.entity.custom.ChunkProtectorBlockEntity;
import net.quedoom.modden.block.geo.ChunkProtectorRenderer;

public class ModTilLServerClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        //BlockEntityRendererFactories.register(ModBlockEntities.CHUNK_PROTECTOR_BE, ChunkProtectorRenderer::new);
    }
}
