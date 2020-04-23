package de.supaadev.particles;

import de.supaadev.particles.commands.StartCMD;
import org.bukkit.plugin.java.JavaPlugin;

public final class Particles extends JavaPlugin {

    private static Particles instance;

    @Override
    public void onEnable() {
        instance = this;
        getCommand("start").setExecutor(new StartCMD());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Particles getInstance() {
        return instance;
    }
}
