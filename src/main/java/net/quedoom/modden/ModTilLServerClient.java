package net.quedoom.modden;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.quedoom.modden.block.entity.ModBlockEntities;
import net.quedoom.modden.block.entity.custom.ChunkProtectorBlockEntity;
import net.quedoom.modden.block.geo.ChunkProtectorRenderer;
import net.quedoom.modden.item.geo.ChunkProtectorBlockItemRenderer;
import net.quedoom.modden.particle.ModParticles;
import net.quedoom.modden.particle.ZzzParticle;

public class ModTilLServerClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        //BlockEntityRendererRegistry.register(ModBlockEntities.CHUNK_PROTECTOR_BE, ChunkProtectorRenderer::new);

        ParticleFactoryRegistry.getInstance().register(ModParticles.ZZZ_PARTICLE, ZzzParticle.Factory::new);
    }
}
