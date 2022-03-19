package com.tundra.finelib.event;

import com.tundra.finelib.FineLib;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

/**
 * Event of Player SignClicked
 */
public class SignClickEvent extends PlayerInteractEvent implements Cancellable {
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private boolean isCancelled;

    /**
     * call Event
     *
     * @param who          player
     * @param action       action
     * @param item         item
     * @param clickedBlock block
     * @param clickedFace  clicked blockface
     * @param hand         clicked Hand
     */
    public SignClickEvent(Player who, Action action, ItemStack item, Block clickedBlock, BlockFace clickedFace, EquipmentSlot hand) {
        super(who, action, item, clickedBlock, clickedFace, hand);
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    /**
     * Event Handler getter
     *
     * @return HandlerList
     */
    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }


    @Override
    public void setCancelled(boolean b) {
        super.setCancelled(b);
    }

    /**
     * Sign getter
     *
     * @return sign
     */
    public Sign getSign() {
        return (Sign) super.getClickedBlock();
    }

    /**
     * Action getter
     *
     * @return Action
     */
    public Action getAction() {
        return super.getAction();
    }

    /**
     * Item getter
     *
     * @return Item
     */
    public ItemStack getItem() {
        return super.getItem();
    }

    /**
     * Material getter
     *
     * @return Material
     */
    public Material getMaterial() {
        return super.getMaterial();
    }

    /**
     * set SignClicked Task
     *
     * @param task runner task
     */
    public void setClickTask(Runnable task) {
        FineLib.syncRunTask(task);
    }

    /**
     * set SignClick Command
     *
     * @param command run command
     */
    public void setClickCommand(String command) {
        getPlayer().performCommand(command);
    }

    /**
     * set SignClick Command
     *
     * @param command run Command
     * @param needOP  check op
     */
    public void setClickCommand(String command, boolean needOP) {
        if (needOP) {
            getPlayer().performCommand(command);
        } else Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
    }
}
