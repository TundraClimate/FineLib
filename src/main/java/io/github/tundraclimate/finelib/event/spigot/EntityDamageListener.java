package io.github.tundraclimate.finelib.event.spigot;

import io.github.tundraclimate.finelib.FineLib;
import io.github.tundraclimate.finelib.event.EntityFallDamageEvent;
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
