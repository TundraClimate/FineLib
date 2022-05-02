package io.github.tundraclimate.finelib

import org.bukkit.scheduler.BukkitRunnable

/**
 * Bukkit runTask
 *
 * @param async async task?
 */
fun <T> T.runTask(async: Boolean = false, task: Runnable) {
    val scheduler = FineLib.getPlugin().server.scheduler
    if (!async) scheduler.runTask(FineLib.getPlugin(), task)
    else scheduler.runTaskAsynchronously(FineLib.getPlugin(), task)
}

/**
 * Bukkit runTask
 *
 * @param async async task?
 */
fun <T> T.runTask(async: Boolean = false, runTask: T.() -> Unit) {
    val task = object : BukkitRunnable() {
        override fun run() {
            runTask()
        }
    }
    if (!async) task.runTask(FineLib.getPlugin())
    else task.runTaskAsynchronously(FineLib.getPlugin())
}

/**
 * Bukkit runTaskLater
 *
 * @param delay task delay
 * @param async async task?
 */
fun <T> T.runTaskLater(delay: Long, async: Boolean = false, task: Runnable) {
    val scheduler = FineLib.getPlugin().server.scheduler
    if (!async) scheduler.runTaskLater(FineLib.getPlugin(), task, delay)
    else scheduler.runTaskLaterAsynchronously(FineLib.getPlugin(), task, delay)
}

/**
 * Bukkit runTaskLater
 *
 * @param delay task delay
 * @param async async task?
 */
fun <T> T.runTaskLater(delay: Long, async: Boolean = false, runTask: T.() -> Unit) {
    val task = object : BukkitRunnable() {
        override fun run() {
            runTask()
        }
    }
    if (!async) task.runTaskLater(FineLib.getPlugin(), delay)
    else task.runTaskLaterAsynchronously(FineLib.getPlugin(), delay)
}

/**
 * Bukkit runTaskTimer
 *
 * @param delay task delay
 * @param period task period
 * @param async async task?
 */
fun <T> T.runTaskTimer(delay: Long, period: Long, async: Boolean = false, task: Runnable) {
    val scheduler = FineLib.getPlugin().server.scheduler
    if (!async) scheduler.runTaskTimer(FineLib.getPlugin(), task, delay, period)
    else scheduler.runTaskTimerAsynchronously(FineLib.getPlugin(), task, delay, period)
}

/**
 * Bukkit runTaskTimer
 *
 * @param delay task delay
 * @param period task period
 * @param async async task?
 */
fun <T> T.runTaskTimer(delay: Long, period: Long, async: Boolean = false, runTask: T.() -> Unit) {
    val task = object : BukkitRunnable() {
        override fun run() {
            runTask()
        }
    }
    if (!async) task.runTaskTimer(FineLib.getPlugin(), delay, period)
    else task.runTaskTimerAsynchronously(FineLib.getPlugin(), delay, period)
}