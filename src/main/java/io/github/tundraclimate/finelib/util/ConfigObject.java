package io.github.tundraclimate.finelib.util;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Create Config of Object Type
 * Useful when used with "object" in Kotlin
 */
public abstract class ConfigObject {
    private FileConfiguration config = null;

    /**
     * Init Config and save Default
     * @param plugin Plugin Instance
     */
    public void init(JavaPlugin plugin) {
        plugin.saveDefaultConfig();
        config = plugin.getConfig();
    }

    /**
     * getter
     * @return config
     */
    public FileConfiguration getConfig() {
        return config;
    }
}
