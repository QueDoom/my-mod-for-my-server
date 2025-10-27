package net.quedoom.modden.effect;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAttachments;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.quedoom.modden.ModTillServer;

public class ModEffects {

    public static final RegistryEntry<StatusEffect> THE_ORB_EFFECT = registerStatusEffect("the_orb_effect",
            new TheOrbEffect(StatusEffectCategory.BENEFICIAL, 0x5de3c1)
                    .addAttributeModifier(EntityAttributes.GENERIC_ARMOR,
                            Identifier.of(ModTillServer.MOD_ID, "the_orb_effect"), 3f,
                            EntityAttributeModifier.Operation.ADD_VALUE)
                    .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,
                            Identifier.of(ModTillServer.MOD_ID, "the_orb_effect"), 1.01f,
                            EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE,
                            Identifier.of(ModTillServer.MOD_ID, "the_orb_effect"), 3f,
                            EntityAttributeModifier.Operation.ADD_VALUE)
                    .addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH,
                            Identifier.of(ModTillServer.MOD_ID, "the_orb_effect"), 20f,
                            EntityAttributeModifier.Operation.ADD_VALUE)
    );


    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(ModTillServer.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        ModTillServer.LOGGER.info("Registering Mod Effects for " + ModTillServer.MOD_ID);
    }
}
