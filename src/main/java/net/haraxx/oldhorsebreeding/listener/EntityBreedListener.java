package net.haraxx.oldhorsebreeding.listener;

import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.AbstractHorse;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityBreedEvent;

import java.util.Random;

public class EntityBreedListener implements Listener {
    @EventHandler
    public void onEntityBreed(EntityBreedEvent breedEvent) {
        if (!(breedEvent.getEntity() instanceof AbstractHorse)) {
            return;
        }

        AbstractHorse breededHorse = (AbstractHorse) breedEvent.getEntity();
        AbstractHorse motherHorse = (AbstractHorse) breedEvent.getMother();
        AbstractHorse fatherHorse = (AbstractHorse) breedEvent.getFather();

        double randomSpeed = new Random().nextDouble(0.1125, 0.3375);
        double randomJumpStrength = new Random().nextDouble(0.4, 1);
        double randomHealth = new Random().nextInt(15, 31);

        breededHorse.setJumpStrength((motherHorse.getJumpStrength() + fatherHorse.getJumpStrength() + randomJumpStrength) / 3);
        breededHorse.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue((
                motherHorse.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getValue()
                + fatherHorse.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getValue()
                + randomSpeed
                ) / 3
        );
        breededHorse.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue((
                motherHorse.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()
                + fatherHorse.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()
                + randomHealth
                ) / 3
        );
    }
}
