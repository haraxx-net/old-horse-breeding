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

        breededHorse.setJumpStrength((
                        ((motherHorse.getJumpStrength() + fatherHorse.getJumpStrength()) / 2)
                        + new Random().nextDouble(0.6)
                ) / 2
        );
        breededHorse.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue((
                (motherHorse.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getValue()
                + motherHorse.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getValue()) / 2
                + (new Random().nextDouble(0.2250) + 0.1125)
        ) / 2);
    }
}
