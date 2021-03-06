package io.github.tundraclimate.finelib;

import io.github.tundraclimate.finelib.event.spigot.ChatEventListener;
import io.github.tundraclimate.finelib.event.spigot.EntityDamageListener;
import io.github.tundraclimate.finelib.event.spigot.PlayerInteractListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

/**
 * Main Class
 */
public final class FineLib {
    private static JavaPlugin plugin;

    /**
     * Plugin getter
     *
     * @return plugin instance
     */
    public static JavaPlugin getPlugin() {
        return plugin;
    }

    /**
     * set Plugin instance
     *
     * @param plugin JavaPlugin instance for plugins that use FineLib
     */
    public static void setPlugin(@NotNull final JavaPlugin plugin) {
        FineLib.plugin = plugin;
        registeringEvent(plugin);
    }

    private static void registeringEvent(JavaPlugin plugin) {
        PluginManager manager = plugin.getServer().getPluginManager();
        manager.registerEvents(new ChatEventListener(), plugin);
        manager.registerEvents(new PlayerInteractListener(), plugin);
        manager.registerEvents(new EntityDamageListener(), plugin);
    }

    /**
     * logging to test
     */
    public static void testLogging() {
        getPlugin().getLogger().info("--- test Logging ---");
    }

    /**
     * logging to message
     *
     * @param message logging Message
     */
    public static void testLogging(String message) {
        getPlugin().getLogger().info(message);
    }

    /**
     * test Log to the plugin console
     *
     * @param plugin logging plugin
     */
    public static void testLogging(JavaPlugin plugin) {
        plugin.getLogger().info("--- test Logging ---");
    }

    /**
     * message Log to the plugin console
     *
     * @param message logging Message
     * @param plugin  logging Plugin
     */
    public static void testLogging(String message, JavaPlugin plugin) {
        plugin.getLogger().info(message);
    }

    /**
     * RunTask of Sync
     *
     * @param runnable Run Task
     */
    public static void syncRunTask(Runnable runnable) {
        Bukkit.getScheduler().runTask(FineLib.getPlugin(), runnable);
    }
}
