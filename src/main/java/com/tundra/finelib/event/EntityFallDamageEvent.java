package com.tundra.finelib.event;

import org.bukkit.entity.Entity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityDamageEvent;

/**
 * FallEntity Called Event
 */
public class EntityFallDamageEvent extends EntityDamageEvent implements Cancellable {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    /**
     * Event Caller
     *
     * @param damagee damager
     * @param cause   Fall
     * @param damage  Damage received
     */
    public EntityFallDamageEvent(Entity damagee, DamageCause cause, double damage) {
        super(damagee, cause, damage);
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    /**
     * HandlerList getter for static
     *
     * @return HandlerList
     */
    public static HandlerList getHandlersList() {
        return HANDLERS_LIST;
    }

    @Override
    public boolean isCancelled() {
        return super.isCancelled();
    }

    @Override
    public void setCancelled(boolean b) {
        super.setCancelled(b);
    }
}
