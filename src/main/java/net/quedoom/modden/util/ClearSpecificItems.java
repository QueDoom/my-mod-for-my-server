package net.quedoom.modden.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.function.Predicate;

public class ClearSpecificItems {

    public static void clearAllItems(PlayerEntity player, Predicate<ItemStack> itemToClear) {
        PlayerInventory inventory = player.getInventory();

        inventory.remove(itemToClear, 99, inventory);
    }
}
