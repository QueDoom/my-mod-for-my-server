package net.quedoom.modden.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class SleeperBlock extends BlockWithEntity implements BlockEntityProvider {
    private static final VoxelShape SHAPE =
            Block.createCuboidShape(0, 0, 0, 16, 2, 16)
            ;
    public static final MapCodec<ChunkProtectorBlock> CODEC = ChunkProtectorBlock.createCodec(ChunkProtectorBlock::new);

    protected SleeperBlock(Settings settings) {
        super(settings);
    }

    public static VoxelShape getSHAPE() {
        return SHAPE;
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return null;
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }
}
