package net.haraxx.oldhorsebreeding;

import net.haraxx.oldhorsebreeding.listener.EntityBreedListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class OldHorseBreedingPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new EntityBreedListener(), this);
    }

    @Override
    public void onDisable() {

    }
}
