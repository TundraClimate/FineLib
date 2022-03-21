package com.tundra.finelib.event.spigot;

import com.tundra.finelib.FineLib;
import com.tundra.finelib.event.EntityFallDamageEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

/**
 * Listen EntityDamage
 */
public class EntityDamageListener implements Listener {
    /**
     * Called EntityFallDamageEvent
     * @param e EntityDamageEvent
     */
    @EventHandler
    public void DetectPlayerDamage(EntityDamageEvent e){
        if (e.getCause() == EntityDamageEvent.DamageCause.FALL)
            FineLib.getPlugin().getServer().getPluginManager()
                    .callEvent(new EntityFallDamageEvent(e.getEntity(),e.getCause(),e.getDamage()));
    }
}