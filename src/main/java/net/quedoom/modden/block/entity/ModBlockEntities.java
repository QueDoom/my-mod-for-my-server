package net.quedoom.modden.block.entity;

import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.quedoom.modden.ModTillServer;
import net.quedoom.modden.block.ModBlocks;
import net.quedoom.modden.block.entity.custom.ChunkProtectorBlockEntity;

public class ModBlockEntities {

    public static final BlockEntityType<ChunkProtectorBlockEntity> CHUNK_PROTECTOR_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(ModTillServer.MOD_ID, "chunk_protector_be"),
                    BlockEntityType.Builder.create(ChunkProtectorBlockEntity::new, ModBlocks.CHUNK_PROTECTOR).build(null))
    ;

    public static void registerBlockEntitites() {
        ModTillServer.LOGGER.info("Registering Block Entities for " + ModTillServer.MOD_ID);
    }
}
