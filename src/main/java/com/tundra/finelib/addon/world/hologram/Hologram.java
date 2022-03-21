package com.tundra.finelib.addon.world.hologram;

import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;

/**
 * HologramObject Interface
 */
public interface Hologram {
    /**
     * set HologramVisible
     *
     * @param b visible
     */
    void setVisible(boolean b);

    /**
     * set Hologram Line
     *
     * @param line Line to Set
     */
    void setHologramLine(String line);

    /**
     * set Hologram Location
     *
     * @param location Location
     */
    void setLocation(Location location);

    /**
     * Hologram remove
     */
    void remove();

    /**
     * init Hologram Setting
     *
     * @param hologram Hologram to init
     */
    default void init(ArmorStand hologram) {
        hologram.setMarker(true);
        hologram.setGravity(true);
        hologram.setVisible(false);
        hologram.setBasePlate(false);
        hologram.setCustomNameVisible(true);
    }
}
