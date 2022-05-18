package io.github.tundraclimate.finelib.database.sqlite

import io.github.tundraclimate.finelib.util.Base64Connector
import org.bukkit.inventory.ItemStack

/**
 * ItemStack DataBase used SQLite
 */
object ItemStackDataBase {
    val sqLite = SQLite("REGISTRY.sqlite")

    /**
     * create ItemStack DataBase
     */
    private fun createTable() {
        if (!sqLite.hasTable("items")) {
            sqLite.executeUpdate("CREATE TABLE items(id TEXT UNIQUE NOT NULL, item TEXT NOT NULL)")
        }
    }

    /**
     * Insert [stack]
     */
    fun insertItemStack(id: String, stack: ItemStack): Boolean {
        val encodeID = Base64Connector.encode(id)
        val encodeStack = Base64Connector.encode(stack)
        if (!sqLite.containValue("items", "id", encodeID)) {
            sqLite.executeUpdate("INSERT INTO items VALUES('$encodeID', '$encodeStack')")
            return true
        }
        return false
    }

    /**
     * Delete ItemStack of [id]
     */
    fun deleteItemStack(id: String) {
        val encodeID = Base64Connector.encode(id)
        if (sqLite.containValue("items", "id", encodeID)) {
            sqLite.executeUpdate("DELETE FROM items WHERE id = '$encodeID'")
        }
    }

    /**
     * Update [stack] of [id]
     */
    fun updateItemStack(id: String, stack: ItemStack) {
        val encodeID = Base64Connector.encode(id)
        val encodeStack = Base64Connector.encode(stack)
        if (sqLite.containValue("items", "id", encodeID)) {
            sqLite.executeUpdate("UPDATE items SET item = '$encodeStack' WHERE id = '$encodeID'")
        }
    }

    /**
     * Select ItemStack of [id]
     */
    fun selectItemStack(id: String): ItemStack? {
        val encodeID = Base64Connector.encode(id)
        if (!sqLite.containValue("items", "id", encodeID)) {
            val rs = sqLite.executeQuery("SELECT item FROM items WHERE id = '$encodeID'")
            val encodeStack = rs.getString("item")
            return Base64Connector.decode(encodeStack) as ItemStack
        }
        return null
    }

    /**
     * Select All ItemStack
     */
    fun selectAll(): Map<String, ItemStack> {
        val map = mutableMapOf<String, ItemStack>()
        val rs = sqLite.executeQuery("SELECT * FROM items")
        while (rs.next()) {
            map[Base64Connector.decode(rs.getString("id")) as String] =
                Base64Connector.decode(rs.getString("item")) as ItemStack
        }
        return map
    }

    /**
     * connect DataBase
     */
    fun connect() {
        sqLite.connectSQLite()
        createTable()
    }

    /**
     * Disconnect DataBase
     */
    fun disconnect() = sqLite.disconnectSQLite()
}