package net.quedoom.modden;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;
import net.quedoom.modden.item.ModItems;

public class ModGameRules {

    public static final GameRules.Key<GameRules.BooleanRule> HAS_ORB =
            GameRuleRegistry.register("hasOrb", GameRules.Category.MISC, GameRuleFactory.createBooleanRule(false));

    public static void registerGamerules() {
        ModTillServer.LOGGER.info("Registering Mod Game Rules for " + ModTillServer.MOD_ID);
    }
}
