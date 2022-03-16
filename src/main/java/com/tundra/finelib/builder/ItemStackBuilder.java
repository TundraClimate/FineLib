package com.tundra.finelib.builder;

import com.tundra.finelib.util.container.DataContainer;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import javax.annotation.Nonnull;
import java.util.*;

/**
 * Building CustomItem
 */
public class ItemStackBuilder {
    private final ItemStack customItem;
    private final ItemMeta customMeta;

    /**
     * set Material
     *
     * @param material CustomItem Material
     */
    public ItemStackBuilder(Material material) {
        this.customItem = new ItemStack(material);
        this.customMeta = customItem.getItemMeta();
    }

    /**
     * set DisplayName
     *
     * @param displayName Custom DisplayName
     * @return this
     */
    public ItemStackBuilder setDisplayName(@Nonnull String displayName) {
        customMeta.setDisplayName(displayName);
        return this;
    }

    /**
     * set DisplayName
     *
     * @param displayName Custom DisplayName
     * @param colorMeta   DisplayName color
     * @return this
     */
    public ItemStackBuilder setDisplayName(@Nonnull String displayName, ChatColor colorMeta) {
        customMeta.setDisplayName(colorMeta + displayName);
        return this;
    }

    /**
     * add DisplayName
     *
     * @param displayName add Custom DisplayName
     * @return this
     */
    public ItemStackBuilder addDisplayName(@Nonnull String displayName) {
        customMeta.setDisplayName(customMeta.getDisplayName() + displayName);
        return this;
    }

    /**
     * add DisplayName
     *
     * @param displayName add Custom DisplayName
     * @param colorMeta   add Color
     * @return this
     */
    public ItemStackBuilder addDisplayName(@Nonnull String displayName, ChatColor colorMeta) {
        customMeta.setDisplayName(customMeta.getDisplayName() + colorMeta + displayName);
        return this;
    }

    /**
     * set Custom Lore
     *
     * @param lore Custom Lore
     * @return this
     */
    public ItemStackBuilder setLore(@Nonnull List<String> lore) {
        customMeta.setLore(lore);
        return this;
    }

    /**
     * set Custom Lore
     *
     * @param lore Custom Lore
     * @return this
     */
    public ItemStackBuilder setLore(@Nonnull Set<String> lore) {
        customMeta.setLore(lore.stream().toList());
        return this;
    }

    /**
     * set Custom Lore
     *
     * @param lore Custom Lore
     * @return this
     */
    public ItemStackBuilder setLore(@Nonnull String... lore) {
        customMeta.setLore(Arrays.asList(lore));
        return this;
    }

    /**
     * add Custom Lore
     *
     * @param lore Custom Lore
     * @return this
     */
    public ItemStackBuilder addLore(@Nonnull List<String> lore) {
        List<String> temp = customMeta.getLore();
        if (temp != null) {
            temp.addAll(lore);
            customMeta.setLore(temp);
        } else customMeta.setLore(lore);
        return this;
    }

    /**
     * add Custom Lore
     *
     * @param lore Custom Lore
     * @return this
     */
    public ItemStackBuilder addLore(@Nonnull Set<String> lore) {
        List<String> temp = customMeta.getLore();
        if (temp != null) {
            temp.addAll(lore);
            customMeta.setLore(temp);
        } else customMeta.setLore(lore.stream().toList());
        return this;
    }

    /**
     * add Custom Lore
     *
     * @param lore Custom Lore
     * @return this
     */
    public ItemStackBuilder addLore(@Nonnull String... lore) {
        List<String> temp = customMeta.getLore();
        if (temp != null) {
            temp.addAll(Arrays.asList(lore));
            customMeta.setLore(temp);
        } else customMeta.setLore(Arrays.asList(lore));
        return this;
    }

    /**
     * set Unbreakable
     *
     * @return this
     */
    public ItemStackBuilder isUnbreakable() {
        customMeta.setUnbreakable(true);
        return this;
    }

    /**
     * add ItemFlags
     *
     * @param flag add ItemFlags
     * @return this
     */
    public ItemStackBuilder addItemFlags(@Nonnull ItemFlag... flag) {
        customMeta.addItemFlags(flag);
        return this;
    }

    /**
     * set CustomModelData
     *
     * @param data CustomModelData
     * @return this
     */
    public ItemStackBuilder setCustomModelData(int data) {
        customMeta.setCustomModelData(data);
        return this;
    }

    /**
     * add CustomItem Enchant
     *
     * @param enchantment add Enchant
     * @param level       Enchant Level
     * @return this
     */
    public ItemStackBuilder addEnchantment(@Nonnull Enchantment enchantment, int level) {
        customMeta.addEnchant(enchantment, level, true);
        return this;
    }

    /**
     * Enchants add private method
     *
     * @param enchantment Enchant
     * @param level       level
     */
    private void Enchantment(Enchantment enchantment, int level) {
        customMeta.addEnchant(enchantment, level, true);
    }

    /**
     * Add enchantments in the map
     *
     * @param enchantments Enchant to Map key = Enchant  value = Level
     * @return this
     */
    public ItemStackBuilder addEnchantments(@Nonnull Map<Enchantment, Integer> enchantments) {
        for (Map.Entry<Enchantment, Integer> entry : enchantments.entrySet()) {
            Enchantment(entry.getKey(), entry.getValue());
        }
        return this;
    }

    /**
     * add Attribute Modifier
     *
     * @param attribute set Attribute
     * @param modifier  Attribute Pair Modifier
     * @return this
     */
    public ItemStackBuilder addAttributeModifier(@Nonnull Attribute attribute, @Nonnull AttributeModifier modifier) {
        customMeta.addAttributeModifier(attribute, modifier);
        return this;
    }

    /**
     * add Metadata ContainerData
     * @param key Data key
     * @param type DataType
     * @param name Data Name
     * @param <T> DataObject
     * @param <Z> DataObject
     * @return this
     */
    public <T, Z> ItemStackBuilder addContainerData(String key, PersistentDataType<T, Z> type, Z name) {
        DataContainer.setDataContainer(customMeta.getPersistentDataContainer(), key, type, name);
        return this;
    }

    /**
     * remove Metadata ContainerData
     * @param key Data key
     * @param <T> DataObject
     * @param <Z> DataObject
     * @return this
     */
    public <T, Z> ItemStackBuilder removeContainerData(String key){
        DataContainer.removeDataContainer(customMeta.getPersistentDataContainer(),key);
        return this;
    }

    /**
     * build CustomItem
     *
     * @return CustomItem
     */
    public ItemStack toItemStack() {
        customItem.setItemMeta(customMeta);
        return customItem;
    }

    /**
     * get CustomItem MetaData
     *
     * @return item Metadata
     */
    public ItemMeta getItemMeta() {
        return customMeta;
    }

    /**
     * get DataContainer
     *
     * @return DataContainer
     */
    public PersistentDataContainer getContainer() {
        return customMeta.getPersistentDataContainer();
    }
}
