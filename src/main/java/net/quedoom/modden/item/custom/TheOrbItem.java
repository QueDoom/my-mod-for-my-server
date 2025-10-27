package net.quedoom.modden.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;
import net.quedoom.modden.effect.ModEffects;

public class TheOrbItem extends Item {
    public TheOrbItem(Settings settings) {
        super(settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (entity instanceof ServerPlayerEntity player && selected) {
            player.addStatusEffect(new StatusEffectInstance(ModEffects.THE_ORB_EFFECT, 2, 0, false, true, true));
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

}
