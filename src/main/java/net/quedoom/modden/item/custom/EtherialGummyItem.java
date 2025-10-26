package net.quedoom.modden.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Identifier;
import net.minecraft.util.UseAction;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.quedoom.modden.ModGameRules;
import net.quedoom.modden.ModTillServer;
import net.quedoom.modden.item.ModItems;

public class EtherialGummyItem extends Item {
    public EtherialGummyItem(Settings settings) {
        super(settings);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.EAT;
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (world.getGameRules().getBoolean(ModGameRules.HAS_ORB)) {
            if (user instanceof PlayerEntity player) {
                player.giveItemStack(new ItemStack(ModItems.THE_ORB));
            }
            world.getGameRules().get(ModGameRules.HAS_ORB).set(false, world.getServer());
        }
        return super.finishUsing(stack, world, user);
    }
}
