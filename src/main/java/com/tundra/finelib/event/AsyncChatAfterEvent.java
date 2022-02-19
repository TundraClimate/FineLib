package com.tundra.finelib.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class AsyncChatAfterEvent extends Event implements Cancellable {
    private final String message;
    private final Player player;
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private boolean isCancelled;
    public AsyncChatAfterEvent(boolean async, Player who, String message){
        super(async);
        this.message = message;
        this.player = who;
    }

    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        this.isCancelled = b;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public Player getPlayer() {
        return player;
    }

    public String getMessage() {
        return message;
    }
}
