package io.github.tundraclimate.finelib.addon.world

import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.World
import org.bukkit.block.Block
import org.bukkit.block.CreatureSpawner
import org.bukkit.entity.EntityType

/**
 * CreatureSpawner Factory
 */
object SpawnerFactory {
    /**
     * CreatureSpawner DataClass
     */
    data class Spawner(
        val entityType: EntityType = EntityType.PIG,
        val delay: Int = 20,
        val spawnCount: Int = 4,
        val spawnRange: Int = 4,
        val playerRange: Int = 16,
        val spawnLimit: Int = 6,
        val delayMin: Int = 200,
        val delayMax: Int = 800
    )

    /**
     * place in [world] [loc]
     *
     * @throws IllegalArgumentException [loc] in [world] not Placeable Height
     */
    fun place(world: World, loc: Location, spawner: Spawner) {
        if (loc.blockY > world.maxHeight || loc.blockY < world.minHeight)
            throw IllegalArgumentException("${loc.blockY} is Over ${world.maxHeight}")
        val block = world.getBlockAt(loc)
        block.type = Material.SPAWNER
        val state = block.state as CreatureSpawner
        state.spawnedType = spawner.entityType
        state.delay = spawner.delay
        state.spawnCount = spawner.spawnCount
        state.spawnRange = spawner.spawnRange
        state.requiredPlayerRange = spawner.playerRange
        state.maxNearbyEntities = spawner.spawnLimit
        state.minSpawnDelay = spawner.delayMin
        state.maxSpawnDelay = spawner.delayMax
        state.update()
    }

    /**
     * update [block] to [spawner]
     *
     * @throws IllegalArgumentException [loc] in [world] not Placeable Height
     */
    fun update(block: Block, spawner: Spawner) {
        place(block.world, block.location, spawner)
    }

    /**
     * place in [world] [loc] on Placeable
     */
    fun placeOrCancel(world: World, loc: Location, spawner: Spawner) {
        val isOut = loc.blockY > world.maxHeight || loc.blockY < world.minHeight
        if (world.getBlockAt(loc).type.isAir && !isOut)
            place(world, loc, spawner)
    }
}