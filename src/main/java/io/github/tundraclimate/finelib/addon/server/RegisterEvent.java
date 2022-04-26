package io.github.tundraclimate.finelib.addon.server;

import io.github.tundraclimate.finelib.FineLib;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.List;

/**
 * Implemented Register Method
 */
public abstract class RegisterEvent implements Listener {

    /**
     * Instance Register
     */
    public void register() {
        FineLib.getPlugin().getServer().getPluginManager().registerEvents(this, FineLib.getPlugin());
    }

    /**
     * static Register
     *
     * @param event Event
     */
    public static void register(RegisterEvent event) {
        FineLib.getPlugin().getServer().getPluginManager().registerEvents(event, FineLib.getPlugin());
    }
}
