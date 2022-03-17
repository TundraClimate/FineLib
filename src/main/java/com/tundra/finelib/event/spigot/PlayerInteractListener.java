package com.tundra.finelib.event.spigot;

import com.tundra.finelib.FineLib;
import com.tundra.finelib.event.SignClickEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * SignEvent callEvent
 */
public class PlayerInteractListener implements Listener {
    /**
     * Detect Clicked Sign
     *
     * @param e InteractEvent
     */
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        if (e.getClickedBlock() == null) {
            return;
        }
        switch (e.getClickedBlock().getType()) {
            case ACACIA_SIGN, ACACIA_WALL_SIGN,
                    SPRUCE_SIGN, SPRUCE_WALL_SIGN,
                    BIRCH_SIGN, BIRCH_WALL_SIGN,
                    OAK_SIGN, OAK_WALL_SIGN,
                    DARK_OAK_SIGN, DARK_OAK_WALL_SIGN,
                    JUNGLE_SIGN, JUNGLE_WALL_SIGN,
                    CRIMSON_SIGN, CRIMSON_WALL_SIGN,
                    WARPED_SIGN, WARPED_WALL_SIGN -> FineLib.syncRunTask(() ->
                    Bukkit.getPluginManager().callEvent(
                            new SignClickEvent(e.getPlayer(), e.getAction(), e.getItem(), e.getClickedBlock(), e.getBlockFace(), e.getHand()))
            );
        }
    }
}
