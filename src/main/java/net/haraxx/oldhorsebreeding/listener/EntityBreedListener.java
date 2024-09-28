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

        Random random = new Random();

        double randomSpeed = (0.44999998807907104D + random.nextDouble() * 0.3D + random.nextDouble() * 0.3D + random.nextDouble() * 0.3D) * 0.25D;
        double randomJumpStrength = 0.4000000059604645D + random.nextDouble() * 0.2D + random.nextDouble() * 0.2D + random.nextDouble() * 0.2D;
        float randomHealth = 15.0F + (float) random.nextInt(8) + (float) random.nextInt(9);

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
