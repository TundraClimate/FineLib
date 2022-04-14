package io.github.tundraclimate.finelib.addon.server;

import com.google.common.collect.Multimap;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.Map;

/**
 * LateInit ItemStack
 */
public class PreItemStack {
    private final ItemStack itemStack;

    /**
     * set Material Type
     *
     * @param material Material of ItemStack
     */
    public PreItemStack(Material material) {
        itemStack = new ItemStack(material);
    }

    /**
     * set Item Amount
     *
     * @param amount ItemStack Amount to set
     * @return ItemStack
     */
    public ItemStack setAmount(int amount) {
        itemStack.setAmount(amount);
        return itemStack;
    }

    /**
     * set Material Type
     *
     * @param type Material type
     * @return ItemStack
     */
    public ItemStack setType(Material type) {
        itemStack.setType(type);
        return itemStack;
    }

    /**
     * set ItemMeta
     *
     * @param itemMeta ItemMeta to set
     * @return ItemStack
     */
    public ItemStack setItemMeta(ItemMeta itemMeta) {
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    /**
     * set ItemStack DisplayName
     *
     * @param displayName DisplayName to set
     * @return ItemStack
     */
    public ItemStack setDisplayName(String displayName) {
        ItemMeta meta = itemStack.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(displayName);
        }
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    /**
     * set ItemStack Lore
     *
     * @param lore Lore to set
     * @return ItemStack
     */
    public ItemStack setLore(List<String> lore) {
        ItemMeta meta = itemStack.getItemMeta();
        if (meta != null) {
            meta.setLore(lore);
        }
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    /**
     * add ItemFlags
     *
     * @param flags ItemFlags to add
     * @return ItemStack
     */
    public ItemStack addItemFlags(ItemFlag... flags) {
        ItemMeta meta = itemStack.getItemMeta();
        if (meta != null) {
            meta.addItemFlags(flags);
        }
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    /**
     * set Unbreakable
     *
     * @param b Unbreakable
     * @return ItemStack
     */
    public ItemStack setUnbreakable(boolean b) {
        ItemMeta meta = itemStack.getItemMeta();
        if (meta != null) {
            meta.setUnbreakable(b);
        }
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    /**
     * set CustomModelData
     *
     * @param value CustomModelData to set
     * @return ItemStack
     */
    public ItemStack setCustomModelData(Integer value) {
        ItemMeta meta = itemStack.getItemMeta();
        if (meta != null) {
            meta.setCustomModelData(value);
        }
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    /**
     * set Attributes
     *
     * @param mod Modifiers
     * @return ItemStack
     */
    public ItemStack setAttributeModifiers(Multimap<Attribute, AttributeModifier> mod) {
        ItemMeta meta = itemStack.getItemMeta();
        if (meta != null) {
            meta.setAttributeModifiers(mod);
        }
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    /**
     * add Attribute
     *
     * @param attribute attribute
     * @param modifier  Modifier
     * @return ItemStack
     */
    public ItemStack addAttributeModifier(Attribute attribute, AttributeModifier modifier) {
        ItemMeta meta = itemStack.getItemMeta();
        if (meta != null) {
            meta.addAttributeModifier(attribute, modifier);
        }
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    /**
     * add Enchantment
     *
     * @param enchantment Enchantment Type
     * @param level       Enchant Level
     * @return ItemStack
     */
    public ItemStack addEnchantment(Enchantment enchantment, int level) {
        itemStack.addUnsafeEnchantment(enchantment, level);
        return itemStack;
    }

    /**
     * add Enchantments
     *
     * @param enchantments Enchant Map
     * @return ItemStack
     */
    public ItemStack addEnchantments(Map<Enchantment, Integer> enchantments) {
        itemStack.addUnsafeEnchantments(enchantments);
        return itemStack;
    }

    /**
     * ItemStack getter
     *
     * @return ItemStack
     */
    public ItemStack getItemStack() {
        return itemStack;
    }
}
