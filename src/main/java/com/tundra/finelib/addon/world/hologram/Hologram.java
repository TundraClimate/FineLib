package com.tundra.finelib.addon.world.hologram;

import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;

public interface Hologram {
    void setVisible(boolean b);

    void setHologramLine(String line);

    void setLocation(Location location);

    void remove();

    default void init(ArmorStand hologram){
        hologram.setMarker(true);
        hologram.setGravity(true);
        hologram.setVisible(false);
        hologram.setBasePlate(false);
        hologram.setCustomNameVisible(true);
    }
}
