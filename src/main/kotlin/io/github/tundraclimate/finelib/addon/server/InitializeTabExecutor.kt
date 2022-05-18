package io.github.tundraclimate.finelib.addon.server

import io.github.tundraclimate.finelib.FineLib
import org.bukkit.command.TabExecutor

/**
 * TabExecutor add Initialize Method
 */
interface InitializeTabExecutor : TabExecutor {
    /**
     * Initialize [command]
     */
    fun init(command: String) {
        FineLib.getPlugin().getCommand(command)?.setExecutor(this)
    }

    companion object {
        /**
         * Initialize [instance] with [command]
         */
        @JvmStatic
        fun init(command: String, instance: InitializeTabExecutor) {
            FineLib.getPlugin().getCommand(command)?.setExecutor(instance)
        }
    }
}