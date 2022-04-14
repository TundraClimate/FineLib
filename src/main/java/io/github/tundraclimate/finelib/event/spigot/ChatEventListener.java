package io.github.tundraclimate.finelib.event.spigot;

import io.github.tundraclimate.finelib.FineLib;
import io.github.tundraclimate.finelib.event.AsyncChatAfterEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Async Chat Listen
 */
public class ChatEventListener implements Listener {
    /**
     * ChatEvent Detect
     * @param e AsyncPlayerChatEvent
     */
    @EventHandler
    protected void ChatDetect(AsyncPlayerChatEvent e){
        new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.getServer().getPluginManager()
                        .callEvent(new AsyncChatAfterEvent(true, e.getPlayer(), e.getMessage()));
            }
        }.runTaskLaterAsynchronously(FineLib.getPlugin(),1L);
    }
}
