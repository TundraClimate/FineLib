package com.tundra.finelib.addon.world.hologram;

import com.tundra.finelib.FineLib;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;

import java.util.ArrayList;
import java.util.List;

public class MultiLineHologram implements Hologram {
    private final List<SingleHologram> hologramLines = new ArrayList<>();

    public MultiLineHologram(Location location, World world) {
        FineLib.syncRunTask(() -> {
            hologramLines.add(new SingleHologram(location, world));
        });
    }

    @Override
    public void setVisible(boolean b) {
        FineLib.syncRunTask(() -> {
            hologramLines.forEach(singleHologram -> singleHologram.setVisible(b));
        });
    }

    @Deprecated
    @Override
    public void setHologramLine(String line) {
        FineLib.syncRunTask(() -> {
            if (hologramLines.size() != 1) return;
            hologramLines.get(0).setHologramLine(line);
        });
    }

    public void setHologramLine(int index, String line) {
        FineLib.syncRunTask(() -> {
            if (hologramLines.size() >= index) {
                hologramLines.get(index).setHologramLine(line);
            } else throw new IndexOutOfBoundsException(index + "is Lines OverFlow!");
        });
    }

    @Deprecated
    @Override
    public void setLocation(Location location) {
        FineLib.syncRunTask(() -> {
            hologramLines.get(0).setLocation(location);
        });
    }

    public void addLine(Location location, World world) {
        FineLib.syncRunTask(() -> {
            SingleHologram hologram = new SingleHologram(location,world);
            hologramLines.add(hologram);
        });
    }

    @Override
    public void remove() {
        FineLib.syncRunTask(() -> {
            hologramLines.forEach(SingleHologram::remove);
        });
    }
}
