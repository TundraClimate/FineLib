package com.tundra.finelib.addon.world.hologram;

import com.tundra.finelib.FineLib;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;

public class SingleHologram implements Hologram {
    private ArmorStand hologram;

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

    public ArmorStand getHologram() {
        return hologram;
    }
}
