package net.quedoom.modden.block.entity.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.quedoom.modden.block.entity.ModBlockEntities;
import net.quedoom.modden.geomodels.ChunkProtectorGeoModel;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.util.GeckoLibUtil;

public class ChunkProtectorBlockEntity extends BlockEntity implements GeoBlockEntity {
    protected static final RawAnimation ACTIVATE_ANIMATION = RawAnimation.begin().thenPlayXTimes("activate", 1).thenLoop("activated");

    private final AnimatableInstanceCache CACHE = GeckoLibUtil.createInstanceCache(this);

    public ChunkProtectorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.CHUNK_PROTECTOR_BE, pos , state);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, this::activateAnimController));
    }

    protected <E extends ChunkProtectorBlockEntity> PlayState activateAnimController(final AnimationState<E> state) {
        return state.setAndContinue(ACTIVATE_ANIMATION);
    }


    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.CACHE;
    }
}
