package com.tundra.finelib;

import com.tundra.finelib.event.SignClickEvent;
import com.tundra.finelib.event.spigot.ChatEventListener;
import com.tundra.finelib.event.spigot.PlayerInteract;
import com.tundra.finelib.util.container.DataContainer;
import org.bukkit.Bukkit;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

import javax.annotation.Nonnull;

/**
 * FineLib MainClass
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
    public static void setPlugin(@Nonnull final JavaPlugin plugin) {
        FineLib.plugin = plugin;
        registeredEvent(plugin);
    }

    private static void registeredEvent(JavaPlugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(new ChatEventListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new PlayerInteract(), plugin);
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
     * @param runnable Run Task
     */
    public static void syncRunTask(Runnable runnable){
        Bukkit.getScheduler().runTask(FineLib.getPlugin(),runnable);
    }
}
