package com.tundra.finelib.event.spigot;

import com.tundra.finelib.FineLib;
import com.tundra.finelib.event.AsyncChatAfterEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class ChatEventListener implements Listener {
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
