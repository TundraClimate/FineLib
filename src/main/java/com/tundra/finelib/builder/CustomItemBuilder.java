package com.tundra.finelib.builder;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class CustomItemBuilder {
    private final ItemStack customItem;
    private final ItemMeta customMeta;
    public CustomItemBuilder(Material material){
        this.customItem = new ItemStack(material);
        this.customMeta = customItem.getItemMeta();
    }

    public CustomItemBuilder setDisplayName(String displayName){
        customMeta.setDisplayName(displayName);
        return this;
    }
    public CustomItemBuilder setDisplayName(String displayName, ChatColor colorMeta){
        customMeta.setDisplayName(colorMeta+displayName);
        return this;
    }
    public CustomItemBuilder addDisplayName(String displayName){
        customMeta.setDisplayName(customMeta.getDisplayName() + displayName);
        return this;
    }
    public CustomItemBuilder addDisplayName(String displayName, ChatColor colorMeta){
        customMeta.setDisplayName(customMeta.getDisplayName() + colorMeta + displayName);
        return this;
    }

    public CustomItemBuilder setLore(List<String> lore){
        customMeta.setLore(lore);
        return this;
    }
    public CustomItemBuilder setLore(Set<String> lore){
        customMeta.setLore(lore.stream().toList());
        return this;
    }
    public CustomItemBuilder setLore(String... lore){
        customMeta.setLore(Arrays.asList(lore));
        return this;
    }
    public CustomItemBuilder addLore(List<String> lore){
        List<String> temp = customMeta.getLore();
        if (temp != null) {
            temp.addAll(lore);
            customMeta.setLore(temp);
        }
        else customMeta.setLore(lore);
        return this;
    }

    public ItemStack toItemStack(){
        customItem.setItemMeta(customMeta);
        return customItem;
    }
}
