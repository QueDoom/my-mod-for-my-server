package net.quedoom.modden.mixin;

import net.fabricmc.fabric.impl.object.builder.FabricEntityTypeImpl;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.ScreenHandler;
import net.quedoom.modden.item.ModItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import javax.management.MXBean;

@Mixin(ScreenHandler.class)
public class DontStoreTheOrbMixin {

    /**
     * Prevents the Orb from being inserted into any container slot.
     * This covers both manual placement and shift-click transfers.
     */
    @Inject(method = "insertItem", at = @At("HEAD"), cancellable = true)
    private void onInsertItem(ItemStack stack, int startIndex, int endIndex, boolean fromLast, CallbackInfoReturnable<Boolean> cir) {
        if (shouldPreventInsert(stack)) {
            cir.setReturnValue(false);
            cir.cancel();
        }
    }

    @Unique
    private boolean shouldPreventInsert(ItemStack stack) {
        if (stack == null || stack.isEmpty()) return false;

        Item orbItem = ModItems.THE_ORB;

        return stack.getItem() == orbItem;
    }
}