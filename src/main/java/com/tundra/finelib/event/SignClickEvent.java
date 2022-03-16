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

/**
 * Event of Player SignClicked
 */
public class SignClickEvent extends PlayerEvent implements Cancellable {
    private Sign sign = null;
    private final ItemStack item;
    private final Action action;
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private boolean isCancelled;

    /**
     * callEvent
     * @param who clicked Player
     * @param sign clicked Sign
     * @param action clicked Action
     * @param item clicked Item
     */
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

    /**
     * Event Handler getter
     * @return HandlerList
     */
    public static HandlerList getHandlerList() {return HANDLERS_LIST;}

    @Override
    public boolean isCancelled() {return isCancelled;}

    @Override
    public void setCancelled(boolean b) {this.isCancelled = b;}

    /**
     * Sign getter
     * @return sign
     */
    public Sign getSign() {return sign;}

    /**
     * Action getter
     * @return Action
     */
    public Action getAction() {return action;}

    /**
     * Item getter
     * @return Item
     */
    public ItemStack getItem() {return item;}

    /**
     * Material getter
     * @return Material
     */
    public Material getMaterial() {return item.getType();}

    /**
     * set SignClicked Task
     * @param task runner task
     */
    public void setClickTask(Runnable task){
        FineLib.syncRunTask(task);
    }

    /**
     * set SignClick Command
     * @param command run command
     */
    public void setClickCommand(String command){
        getPlayer().performCommand(command);
    }

    /**
     * set SignClick Command
     * @param command run Command
     * @param needOP check op
     */
    public void setClickCommand(String command, boolean needOP){
        if (needOP){
            getPlayer().performCommand(command);
        }
        else Bukkit.dispatchCommand(Bukkit.getConsoleSender(),command);
    }
}
