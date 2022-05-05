package io.github.tundraclimate.finelib.util

import io.github.tundraclimate.finelib.FineLib
import org.bukkit.scheduler.BukkitRunnable

/**
 * run [task] on [async]
 */
fun runTask(async: Boolean = false, task: Runnable) {
    val scheduler = FineLib.getPlugin().server.scheduler
    if (!async) scheduler.runTask(FineLib.getPlugin(), task)
    else scheduler.runTaskAsynchronously(FineLib.getPlugin(), task)
}

/**
 * run [task] on [async]
 */
fun <T> T.runTask(async: Boolean = false, task: Runnable) {
    val scheduler = FineLib.getPlugin().server.scheduler
    if (!async) scheduler.runTask(FineLib.getPlugin(), task)
    else scheduler.runTaskAsynchronously(FineLib.getPlugin(), task)
}

/**
 * run [runTask] on [async]
 */
fun <T> T.runTask(async: Boolean = false, task: T.() -> Unit) {
    val runnable = object : BukkitRunnable() {
        override fun run() {
            task()
        }
    }
    if (!async) runnable.runTask(FineLib.getPlugin())
    else runnable.runTaskAsynchronously(FineLib.getPlugin())
}

/**
 * run [task] on [async] to [delay]
 */
fun runTaskLater(delay: Long, async: Boolean = false, task: Runnable) {
    val scheduler = FineLib.getPlugin().server.scheduler
    if (!async) scheduler.runTaskLater(FineLib.getPlugin(), task, delay)
    else scheduler.runTaskLaterAsynchronously(FineLib.getPlugin(), task, delay)
}

/**
 * run [task] on [async] to [delay]
 */
fun <T> T.runTaskLater(delay: Long, async: Boolean = false, task: Runnable) {
    val scheduler = FineLib.getPlugin().server.scheduler
    if (!async) scheduler.runTaskLater(FineLib.getPlugin(), task, delay)
    else scheduler.runTaskLaterAsynchronously(FineLib.getPlugin(), task, delay)
}

/**
 * run [runTask] on [async] to [delay]
 */
fun <T> T.runTaskLater(delay: Long, async: Boolean = false, task: T.() -> Unit) {
    val runnable = object : BukkitRunnable() {
        override fun run() {
            task()
        }
    }
    if (!async) runnable.runTaskLater(FineLib.getPlugin(), delay)
    else runnable.runTaskLaterAsynchronously(FineLib.getPlugin(), delay)
}