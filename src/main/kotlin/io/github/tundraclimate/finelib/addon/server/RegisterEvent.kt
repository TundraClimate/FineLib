package io.github.tundraclimate.finelib.addon.server

import io.github.tundraclimate.finelib.FineLib
import io.github.tundraclimate.finelib.addon.server.RegisterEvent
import org.bukkit.event.Listener

/**
 * Implemented Register Method
 */
interface RegisterEvent : Listener {
    /**
     * Instance Register
     */
    fun register() {
        FineLib.getPlugin().server.pluginManager.registerEvents(this, FineLib.getPlugin())
    }

    companion object {
        /**
         * static Register
         *
         * @param event Event
         */
        @JvmStatic
        fun register(event: RegisterEvent?) {
            FineLib.getPlugin().server.pluginManager.registerEvents(event!!, FineLib.getPlugin())
        }
    }
}