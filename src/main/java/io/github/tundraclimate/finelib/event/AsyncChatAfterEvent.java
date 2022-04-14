package io.github.tundraclimate.finelib.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Events called after asynchronous chat
 */
public class AsyncChatAfterEvent extends Event implements Cancellable {
    private final String message;
    private final Player player;
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private boolean isCancelled;

    /**
     * Get chat information
     *
     * @param async   isAsync
     * @param who     Chatting Player
     * @param message Chat Message
     */
    public AsyncChatAfterEvent(boolean async, Player who, String message) {
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

    /**
     * return Handler List
     *
     * @return Handlers list
     */
    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    /**
     * Chatting Player getter
     *
     * @return Chatting Player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Message getter
     *
     * @return Chat Message
     */
    public String getMessage() {
        return message;
    }
}
