package net.quedoom.modden.mixin;

import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.MinecraftServer;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.quedoom.modden.item.ModItems;
import net.quedoom.modden.util.ClearSpecificItems;
import net.quedoom.modden.util.GiveOrbAfterCancelDrop;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import javax.swing.*;
import java.util.function.Predicate;

@Mixin(PlayerEntity.class)
public class DontDropTheOrbMixin {

//    // Handle pressing Q to drop the selected item
//    @Inject(method = "method_31548", at = @At("HEAD"), cancellable = true)
//    private void onDropSelectedItem(boolean entireStack, CallbackInfoReturnable<ItemEntity> cir) {
//        PlayerEntity player = (PlayerEntity) (Object) this;
//        ItemStack stack = player.getMainHandStack();
//
//        if (shouldPreventDrop(stack)) {
//            player.sendMessage(Text.literal("You cannot drop the Orb!"), true);
//            cir.setReturnValue(null);
//            cir.cancel();
//        }
//    }

    // Handle inventory drop (drag outside inventory, etc.)
    @Inject(method = "dropItem(Lnet/minecraft/item/ItemStack;ZZ)Lnet/minecraft/entity/ItemEntity;", at = @At("HEAD"), cancellable = true)
    private void onDropItem(ItemStack stack, boolean throwRandomly, boolean retainOwnership, CallbackInfoReturnable<ItemEntity> cir) {
        if (shouldPreventDrop(stack)) {
            PlayerEntity player = (PlayerEntity) (Object) this;
            stack.increment(0); // sync visuals
            player.getInventory().markDirty();
            player.sendMessage(Text.literal("You cannot drop the Orb!"), true);
            cir.setReturnValue(null);
            cir.cancel();
            GiveOrbAfterCancelDrop.give(stack, player);

        }
    }

    @Unique
    private boolean shouldPreventDrop(ItemStack stack) {
        if (stack == null || stack.isEmpty()) return false;

        // 🪄 Replace this with your actual Orb item
        Item orbItem = ModItems.THE_ORB;

        return stack.getItem() == orbItem;
    }
}