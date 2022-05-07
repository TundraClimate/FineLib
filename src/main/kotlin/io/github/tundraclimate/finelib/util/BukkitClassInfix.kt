package io.github.tundraclimate.finelib.util

import org.bukkit.Material
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import java.lang.IllegalArgumentException

/**
 * Inventory plus [stack]
 */
operator fun Inventory.plus(stack: ItemStack): Inventory = this.apply { addItem(stack) }

/**
 * Inventory plus [material]
 */
operator fun Inventory.plus(material: Material): Inventory = plus(ItemStack(material))

/**
 * Inventory minus [stack]
 *
 * @throws IllegalArgumentException [stack] of not Found Inventory
 */
operator fun Inventory.minus(stack: ItemStack): Inventory {
    try {
        this.filter { it.isSimilar(stack) && it.amount >= stack.amount }[0].amount -= stack.amount
    } catch (e: ArrayIndexOutOfBoundsException) {
        throw IllegalArgumentException("can't minus ItemStack")
    }
    return this
}

/**
 * Inventory minus [material]
 *
 * @throws IllegalArgumentException [stack] of not Found Inventory
 */
operator fun Inventory.minus(material: Material): Inventory = minus(ItemStack(material))