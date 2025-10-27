package net.quedoom.modden.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.quedoom.modden.item.ModItems;

public class GiveOrbAfterCancelDrop {

    public static void give(ItemStack itemStack, PlayerEntity player) {
        player.giveItemStack(new ItemStack(ModItems.THE_ORB));
    }
}
