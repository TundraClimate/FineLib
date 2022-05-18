package io.github.tundraclimate.finelib.util

import org.bukkit.Location
import org.bukkit.attribute.AttributeModifier
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta
import org.bukkit.potion.PotionEffect
import org.bukkit.util.io.BukkitObjectInputStream
import org.bukkit.util.io.BukkitObjectOutputStream
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream

/**
 * Convert [ Object <-> Nullable Base64 ]
 */
object Base64Converter {
    /**
     * Convert [stack] -> Base64 String
     */
    fun itemStackToBase64(stack: ItemStack): String? {
        return try {
            val os = ByteArrayOutputStream()
            val bos = BukkitObjectOutputStream(os)

            bos.writeObject(stack)

            bos.close()
            Base64Coder.encodeLines(os.toByteArray())
        } catch (e: Exception) {
            null
        }
    }

    /**
     * Convert [encoded] String -> ItemStack
     */
    fun base64ToItemStack(encoded: String): ItemStack? {
        return try {
            val bis = ByteArrayInputStream(Base64Coder.decodeLines(encoded))
            val bois = BukkitObjectInputStream(bis)

            bois.readObject() as? ItemStack
        } catch (e: Exception) {
            null
        }
    }

    /**
     * Convert [stacks] -> Base64 String
     */
    fun itemStacksToBase64(stacks: Array<ItemStack>): String? {
        return try {
            val os = ByteArrayOutputStream()
            val bos = BukkitObjectOutputStream(os)

            bos.writeInt(stacks.size)

            for (stack in stacks) {
                bos.writeObject(stack)
            }
            bos.close()
            Base64Coder.encodeLines(os.toByteArray())
        } catch (e: Exception) {
            null
        }
    }

    /**
     * Convert [encoded] String -> ItemStack Array
     */
    fun base64ToItemStacks(encoded: String): Array<ItemStack?> {
        return try {
            val bis = ByteArrayInputStream(Base64Coder.decodeLines(encoded))
            val bois = BukkitObjectInputStream(bis)

            val stacks = arrayOfNulls<ItemStack>(bois.readInt())

            for (i in stacks.indices) {
                stacks[i] = bois.readObject() as? ItemStack
            }

            bois.close()
            stacks
        } catch (e: Exception) {
            emptyArray()
        }
    }

    /**
     * Convert [loc] -> Base64 String
     */
    fun locationToBase64(loc: Location): String? {
        return try {
            val os = ByteArrayOutputStream()
            val bos = BukkitObjectOutputStream(os)

            bos.writeObject(loc)

            bos.close()
            Base64Coder.encodeLines(os.toByteArray())
        } catch (e: Exception) {
            null
        }
    }

    /**
     * Convert [encoded] String -> Location
     */
    fun base64ToLocation(encoded: String): Location? {
        return try {
            val bis = ByteArrayInputStream(Base64Coder.decodeLines(encoded))
            val bois = BukkitObjectInputStream(bis)

            bois.readObject() as? Location
        } catch (e: Exception) {
            null
        }
    }

    /**
     * Convert [mod] -> Base64 String
     */
    fun modifierToBase64(mod: AttributeModifier): String? {
        return try {
            val os = ByteArrayOutputStream()
            val bos = BukkitObjectOutputStream(os)

            bos.writeObject(mod)

            bos.close()
            Base64Coder.encodeLines(os.toByteArray())
        } catch (e: Exception) {
            null
        }
    }

    /**
     * Convert [encoded] String -> Modifier
     */
    fun base64ToModifier(encoded: String): AttributeModifier? {
        return try {
            val bis = ByteArrayInputStream(Base64Coder.decodeLines(encoded))
            val bois = BukkitObjectInputStream(bis)

            bois.readObject() as? AttributeModifier
        } catch (e: Exception) {
            null
        }
    }

    /**
     * Convert [eff] -> Base64 String
     */
    fun potEffToBase64(eff: PotionEffect): String? {
        return try {
            val os = ByteArrayOutputStream()
            val bos = BukkitObjectOutputStream(os)

            bos.writeObject(eff)

            bos.close()
            Base64Coder.encodeLines(os.toByteArray())
        } catch (e: Exception) {
            null
        }
    }

    /**
     * Convert [encoded] String -> PotionEffect
     */
    fun base64ToPotEff(encoded: String): PotionEffect? {
        return try {
            val bis = ByteArrayInputStream(Base64Coder.decodeLines(encoded))
            val bois = BukkitObjectInputStream(bis)

            bois.readObject() as? PotionEffect
        } catch (e: Exception) {
            null
        }
    }

    /**
     * Convert [pl] -> Base64 String
     */
    fun playerToBase64(pl: Player): String? {
        return try {
            val os = ByteArrayOutputStream()
            val bos = BukkitObjectOutputStream(os)

            bos.writeObject(pl)

            bos.close()
            Base64Coder.encodeLines(os.toByteArray())
        } catch (e: Exception) {
            null
        }
    }

    /**
     * Convert [encoded] String -> Player
     */
    fun base64ToPlayer(encoded: String): Player? {
        return try {
            val bis = ByteArrayInputStream(Base64Coder.decodeLines(encoded))
            val bois = BukkitObjectInputStream(bis)

            bois.readObject() as? Player
        } catch (e: Exception) {
            null
        }
    }

    /**
     * Convert [meta] -> Base64 String
     */
    fun itemMetaToBase64(meta: ItemMeta): String? {
        return try {
            val os = ByteArrayOutputStream()
            val bos = BukkitObjectOutputStream(os)

            bos.writeObject(meta)

            bos.close()
            Base64Coder.encodeLines(os.toByteArray())
        } catch (e: Exception) {
            null
        }
    }

    /**
     * Convert [encoded] String -> ItemMeta
     */
    fun base64ToItemMeta(encoded: String): ItemMeta? {
        return try {
            val bis = ByteArrayInputStream(Base64Coder.decodeLines(encoded))
            val bois = BukkitObjectInputStream(bis)

            bois.readObject() as? ItemMeta
        } catch (e: Exception) {
            null
        }
    }

    /**
     * Split [stack] to ItemStack and ItemMeta
     */
    fun splitItemStackAndMeta(stack: ItemStack): Pair<String?, String?> {
        val meta = stack.itemMeta
        val stackOfType = ItemStack(stack.type)

        val cMeta = meta?.let { itemMetaToBase64(it) }
        val cStackOfType = itemStackToBase64(stackOfType)

        return cStackOfType to cMeta
    }

    /**
     * Merge [stack] and [meta] to ItemStack
     */
    fun mergeToItemStack(stack: String, meta: String): ItemStack? {
        val itemStack = base64ToItemStack(stack)
        val itemMeta = base64ToItemMeta(meta)

        itemStack?.itemMeta = itemMeta

        return itemStack
    }
}