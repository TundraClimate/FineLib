package com.tundra.finelib;

import com.tundra.finelib.event.spigot.ChatEventListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class FineLib {
    private static JavaPlugin plugin;

    public static JavaPlugin getPlugin() {return plugin;}

    public static void setPlugin(final JavaPlugin plugin) {
        FineLib.plugin = plugin;
        registeredEvent(plugin);
    }

    private static void registeredEvent(JavaPlugin plugin){
        plugin.getServer().getPluginManager().registerEvents(new ChatEventListener(),plugin);
    }

    public static void testLogging(){getPlugin().getLogger().info("--- test Logging ---");}
    public static void testLogging(String message){getPlugin().getLogger().info(message);}
    public static void testLogging(JavaPlugin plugin){plugin.getLogger().info("--- test Logging ---");}
    public static void testLogging(String message, JavaPlugin plugin){plugin.getLogger().info(message);}
}
