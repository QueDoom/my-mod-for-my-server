package net.quedoom.modden.item.custom;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.quedoom.modden.item.ModItems;


public class TheAetherShearsItem extends Item {
    public TheAetherShearsItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);

        if (!world.isClient) {
            // break:
            if (!player.isCreative()) {
                stack.damage(stack.getMaxDamage(), player, EquipmentSlot.MAINHAND);
                world.playSound(null, player.getX(), player.getY(), player.getZ(),
                        SoundEvents.ENTITY_ITEM_BREAK, SoundCategory.PLAYERS, 1.0F, 1.0F);
            } else {
                player.giveItemStack(new ItemStack(ModItems.SOUL));
                world.playSound(null, player.getX(), player.getY(), player.getZ(),
                        SoundEvents.ENTITY_SHEEP_SHEAR, SoundCategory.PLAYERS, 1.0f, 1.0f);
            }
        }

        return TypedActionResult.success(stack, world.isClient());
    }

}
