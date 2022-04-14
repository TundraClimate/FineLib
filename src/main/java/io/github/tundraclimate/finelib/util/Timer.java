package io.github.tundraclimate.finelib.util;

import io.github.tundraclimate.finelib.FineLib;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

/**
 * Timer Class
 */
public class Timer {
    /**
     * Create Timer
     *
     * @param time time second
     * @param task runner Task
     * @return Timer
     */
    public static BukkitTask createTimer(double time, Runnable task) {
        return new BukkitRunnable() {
            @Override
            public void run() {
                FineLib.syncRunTask(task);
            }
        }.runTaskLater(FineLib.getPlugin(), (long) time * 20);
    }
}
