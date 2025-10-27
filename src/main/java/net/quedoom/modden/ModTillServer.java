package net.quedoom.modden;

import net.fabricmc.api.ModInitializer;

import net.quedoom.modden.block.ModBlocks;
import net.quedoom.modden.block.entity.ModBlockEntities;
import net.quedoom.modden.effect.ModEffects;
import net.quedoom.modden.item.ModItems;
import net.quedoom.modden.particle.ModParticles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModTillServer implements ModInitializer {
	public static final String MOD_ID = "modden";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);



	@Override
	public void onInitialize() {
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();

        ModEffects.registerEffects();

        ModBlockEntities.registerBlockEntitites();

        ModGameRules.registerGamerules();

        ModParticles.registerParticles();

	}
}