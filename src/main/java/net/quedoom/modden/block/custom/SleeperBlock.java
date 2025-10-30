package net.quedoom.modden.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class SleeperBlock extends BlockWithEntity implements BlockEntityProvider {
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
    private static final VoxelShape SHAPE =
            Block.createCuboidShape(0, 0, 0, 16, 2, 16)
            ;
    public static final MapCodec<ChunkProtectorBlock> CODEC = ChunkProtectorBlock.createCodec(ChunkProtectorBlock::new);

    protected SleeperBlock(Settings settings) {
        super(settings);
        setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH));
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, getRandomDirection());
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

    @Override
    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        // The block below this one
        BlockPos belowPos = pos.down();
        BlockState belowState = world.getBlockState(belowPos);

        // Check if the top side of the below block is solid (can support our block)
        return belowState.isSideSolidFullSquare(world, belowPos, Direction.UP);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        super.randomDisplayTick(state, world, pos, random);

        // ----- Null object position from Blockbench -----
        // (0, 1, 3)  → convert from model units (16 per block)
        double relX = 0 / 16.0;
        double relY = 1 / 16.0;
        double relZ = 3 / 16.0;

        // Center of block
        double baseX = pos.getX() + 0.5;
        double baseY = pos.getY();
        double baseZ = pos.getZ() + 0.5;

        Direction facing = state.get(FACING);

        // ----- Rotate offsets based on facing -----
        double xOffset = 0;
        double zOffset = 0;

        switch (facing) {
            case NORTH -> {
                xOffset = relX - 0.5;
                zOffset = relZ - 0.5;
            }
            case SOUTH -> {
                xOffset = -relX + 0.5;
                zOffset = -relZ + 0.5;
            }
            case EAST -> {
                xOffset = relZ - 0.5;
                zOffset = -relX + 0.5;
            }
            case WEST -> {
                xOffset = -relZ + 0.5;
                zOffset = relX - 0.5;
            }
        }

        double x = baseX + xOffset;
        double y = baseY + relY;
        double z = baseZ + zOffset;

        // ----- Spawn particle -----
        world.addParticle(ParticleTypes.FLAME, x, y, z, 0, 0, 0);
    }
}
