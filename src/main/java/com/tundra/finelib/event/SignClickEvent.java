package com.tundra.finelib.event;

import com.tundra.finelib.FineLib;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.inventory.ItemStack;

public class SignClickEvent extends PlayerEvent implements Cancellable {
    private Sign sign = null;
    private final ItemStack item;
    private final Action action;
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private boolean isCancelled;

    public SignClickEvent(Player who, Block sign, Action action, ItemStack item) {
        super(who);
        if (!sign.getLocation().getBlock().isEmpty())
            this.sign = (Sign) sign.getState();
        this.action = action;
        this.item = item;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }
    public static HandlerList getHandlerList() {return HANDLERS_LIST;}

    @Override
    public boolean isCancelled() {return isCancelled;}

    @Override
    public void setCancelled(boolean b) {this.isCancelled = b;}

    public Sign getSign() {return sign;}

    public Action getAction() {return action;}

    public ItemStack getItem() {return item;}

    public Material getMaterial() {return item.getType();}

    public void setClickTask(Runnable task){
        FineLib.syncRunTask(task);
    }
    public void setClickCommand(String command){
        getPlayer().performCommand(command);
    }
    public void setClickCommand(String command, boolean needOP){
        if (needOP){
            getPlayer().performCommand(command);
        }
        else Bukkit.dispatchCommand(Bukkit.getConsoleSender(),command);
    }
}
