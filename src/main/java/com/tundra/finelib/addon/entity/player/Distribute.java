package com.tundra.finelib.addon.entity.player;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Distribution Object
 */
public class Distribute {
    /**
     * Distribute items
     * @param items Items to distribute
     */
    public static void distributeItem(ItemStack... items) {
        Bukkit.getOnlinePlayers().forEach(player -> player.getInventory().addItem(items));
    }

    /**
     * Distribute items
     * @param items Items to distribute
     */
    public static void distributeItem(List<ItemStack> items) {
        Collection<? extends Player> players = Bukkit.getOnlinePlayers();
        items.forEach(stack -> players.forEach(player -> player.getInventory().addItem(stack)));
    }

    /**
     * Distribute items
     * @param players Players to distribute
     * @param items Items to distribute
     */
    public static void distributeItem(Player[] players, ItemStack... items) {
        Arrays.asList(players).forEach(player -> player.getInventory().addItem(items));
    }

    /**
     * Distribute items
     * @param players Players to distribute
     * @param items Items to distribute
     */
    public static void distributeItem(List<Player> players, ItemStack... items) {
        players.forEach(player -> player.getInventory().addItem(items));
    }

    /**
     * Distribute items
     * @param players Players to distribute
     * @param items Items to distribute
     */
    public static void distributeItem(Set<Player> players, ItemStack... items) {
        players.forEach(player -> player.getInventory().addItem(items));
    }

    /**
     * Distribute items
     * @param players Players to distribute
     * @param items Items to distribute
     */
    public static void distributeItem(Player[] players, List<ItemStack> items) {
        items.forEach(stack -> Arrays.asList(players).forEach(player -> player.getInventory().addItem(stack)));
    }

    /**
     * Distribute items
     * @param players Players to distribute
     * @param items Items to distribute
     */
    public static void distributeItem(List<Player> players, List<ItemStack> items) {
        items.forEach(stack -> players.forEach(player -> player.getInventory().addItem(stack)));
    }

    /**
     * Distribute items
     * @param players Players to distribute
     * @param items Items to distribute
     */
    public static void distributeItem(Set<Player> players, List<ItemStack> items) {
        items.forEach(stack -> players.forEach(player -> player.getInventory().addItem(stack)));
    }

    /**
     * Distribute PotionEffects
     * @param effects Effect to distribute
     */
    public static void distributePotEff(PotionEffect... effects) {
        Bukkit.getOnlinePlayers().forEach(player -> player.addPotionEffects(Arrays.asList(effects)));
    }

    /**
     * Distribute PotionEffects
     * @param effects Effect to distribute
     */
    public static void distributePotEff(List<PotionEffect> effects) {
        Bukkit.getOnlinePlayers().forEach(player -> player.addPotionEffects(effects));
    }

    /**
     * Distribute PotionEffects
     * @param effects Effect to distribute
     */
    public static void distributePotEff(Set<PotionEffect> effects) {
        Bukkit.getOnlinePlayers().forEach(player -> player.addPotionEffects(effects));
    }
}
