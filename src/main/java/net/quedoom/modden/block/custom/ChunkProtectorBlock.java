package net.quedoom.modden.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.s2c.play.ScreenHandlerPropertyUpdateS2CPacket;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.quedoom.modden.block.entity.ModBlockEntities;
import net.quedoom.modden.block.entity.custom.ChunkProtectorBlockEntity;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.model.GeoModel;

public class ChunkProtectorBlock extends BlockWithEntity implements BlockEntityProvider {
    private static final VoxelShape SHAPE =
            Block.createCuboidShape(2, 0, 2, 14, 13, 14)
    ;
    public static final MapCodec<ChunkProtectorBlock> CODEC = ChunkProtectorBlock.createCodec(ChunkProtectorBlock::new);

    public ChunkProtectorBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new ChunkProtectorBlockEntity(pos, state);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!(world.getBlockEntity(pos) instanceof ChunkProtectorBlockEntity chunkProtectorBlockEntity)) {
            return super.onUse(state, world, pos, player, hit);
        }
        chunkProtectorBlockEntity.setActive(chunkProtectorBlockEntity.getUuid() == player.getUuid());
        return ActionResult.SUCCESS;
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        if ((world.getBlockEntity(pos) instanceof ChunkProtectorBlockEntity chunkProtectorBlockEntity)) {
            if (placer instanceof PlayerEntity player) {
                chunkProtectorBlockEntity.setUuid(player.getUuid());
            }
        }

    }
}
