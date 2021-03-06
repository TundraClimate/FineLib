package io.github.tundraclimate.finelib.util;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.lang.reflect.Field;
import java.util.UUID;

/**
 * Gen CustomHead
 */
public final class HeadGenerator {
    /**
     * Please Use https://mineskin.org/
     *
     * @param value skin Value
     * @return Head
     */
    public static ItemStack getHead(String value) {
        ItemStack head = new ItemStack(Material.PLAYER_HEAD);
        ItemMeta headMeta = head.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        profile.getProperties().put("textures", new Property("textures", value));
        Field profileField = null;
        try {
            profileField = headMeta.getClass().getDeclaredField("profile");
        } catch (NoSuchFieldException | SecurityException e) {
            e.printStackTrace();
        }
        profileField.setAccessible(true);
        try {
            profileField.set(headMeta, profile);
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
        head.setItemMeta(headMeta);
        return head;
    }

    /**
     * get Head from UUID
     *
     * @param value skin Value
     * @param uuid  UUID
     * @return Head
     */
    public static ItemStack getHead(String value, String uuid) {
        ItemStack head = new ItemStack(Material.PLAYER_HEAD);
        ItemMeta headMeta = head.getItemMeta();
        GameProfile profile = new GameProfile(UUID.fromString(uuid), null);
        profile.getProperties().put("textures", new Property("textures", value));
        Field profileField = null;
        try {
            profileField = headMeta.getClass().getDeclaredField("profile");
        } catch (NoSuchFieldException | SecurityException e) {
            e.printStackTrace();
        }
        profileField.setAccessible(true);
        try {
            profileField.set(headMeta, profile);
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
        head.setItemMeta(headMeta);
        return head;
    }

    /**
     * get Head to ItemStack from UUID
     *
     * @param head  Head ItemStack
     * @param value skin Value
     * @param uuid  UUID
     * @return Head
     */
    public static ItemStack getHead(ItemStack head, String value, String uuid) {
        if (head.getType() != Material.PLAYER_HEAD) return head;
        ItemMeta headMeta = head.getItemMeta();
        GameProfile profile = new GameProfile(UUID.fromString(uuid), null);
        profile.getProperties().put("textures", new Property("textures", value));
        Field profileField = null;
        try {
            profileField = headMeta.getClass().getDeclaredField("profile");
        } catch (NoSuchFieldException | SecurityException e) {
            e.printStackTrace();
        }
        profileField.setAccessible(true);
        try {
            profileField.set(headMeta, profile);
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
        head.setItemMeta(headMeta);
        return head;
    }
}
