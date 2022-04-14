package io.github.tundraclimate.finelib.addon.world.hologram;

import io.github.tundraclimate.finelib.FineLib;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;

/**
 * SingleLine Hologram
 */
public class SingleHologram implements Hologram {
    private ArmorStand hologram;

    /**
     * set Hologram Location
     * @param location location
     * @param world world
     */
    public SingleHologram(Location location, World world) {
        FineLib.syncRunTask(() -> {
            hologram = (ArmorStand) world.spawnEntity(location, EntityType.ARMOR_STAND);
            init(hologram);
        });
    }

    @Override
    public void setVisible(boolean b) {
        FineLib.syncRunTask(() -> getHologram().setCustomNameVisible(b));
    }

    @Override
    public void setHologramLine(String line) {
        FineLib.syncRunTask(() -> getHologram().setCustomName(line));
    }

    @Override
    public void setLocation(Location location) {
        FineLib.syncRunTask(() -> {
            Location loc = getHologram().getLocation();
            loc.setX(location.getX());
            loc.setY(location.getY());
            loc.setZ(location.getZ());
        });
    }

    @Override
    public void remove() {
        FineLib.syncRunTask(()-> getHologram().remove());
    }

    /**
     * hologram getter
     * @return hologram Entity
     */
    public ArmorStand getHologram() {
        return hologram;
    }
}
