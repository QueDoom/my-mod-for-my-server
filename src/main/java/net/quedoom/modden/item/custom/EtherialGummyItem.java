package net.quedoom.modden.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.MinecraftServer;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.UseAction;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.quedoom.modden.ModGameRules;
import net.quedoom.modden.ModTillServer;
import net.quedoom.modden.item.ModItems;

import java.util.List;

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
                net.minecraft.server.MinecraftServer server = world.getServer();
                if (server != null) {
                    Text message = Text.literal(player.getName().getString() + " has got the Orb! They are at x: " + Math.round(player.getPos().x) + " y: " + Math.round(player.getPos().y) + " z: " + Math.round(player.getPos().z));
                    server.getPlayerManager().broadcast(message, false);
                }
            }
            world.getGameRules().get(ModGameRules.HAS_ORB).set(false, world.getServer());
        }
        return super.finishUsing(stack, world, user);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {

        tooltip.add(Text.translatable("tooltip.modden.etherial_gummy"));

        super.appendTooltip(stack, context, tooltip, type);
    }
}
