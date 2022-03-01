package com.tundra.finelib.builder;

import com.tundra.finelib.FineLib;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

/**
 * Build Inventory
 */
public class InventoryBuilder {
    private final Inventory inventory;

    /**
     * set InventoryHeight
     * @param invHeight inventory GUI Height
     */
    public InventoryBuilder(int invHeight) {
        inventory = Bukkit.createInventory(null, invHeight * 9);
    }

    /**
     * set InventoryHeight and InventoryTitle
     * @param invHeight Inventory GUI Height
     * @param title Inventory GUI Name
     */
    public InventoryBuilder(int invHeight, String title) {
        inventory = Bukkit.createInventory(null, invHeight * 9, title);
    }

    /**
     * set InventoryType and InventoryTitle
     * @param type Inventory GUI Type
     * @param title Inventory GUI Name
     */
    public InventoryBuilder(InventoryType type, String title) {
        inventory = Bukkit.createInventory(null, type, title);
    }

    /**
     * set InventoryHolder and InventoryHeight
     * @param holder Inventory GUI Holder
     * @param invHeight Inventory GUI Height
     */
    public InventoryBuilder(InventoryHolder holder, int invHeight) {
        inventory = Bukkit.createInventory(holder, invHeight * 9);
    }

    /**
     * set InventoryHolder and InventoryType
     * @param holder Inventory GUI Holder
     * @param type Inventory GUI Type
     */
    public InventoryBuilder(InventoryHolder holder, InventoryType type) {
        inventory = Bukkit.createInventory(holder, type);
    }

    /**
     * set InventoryHolder, InventoryType and InventoryTitle
     * @param holder Inventory GUI Holder
     * @param type Inventory GUI Type
     * @param title Inventory GUI Name
     */
    public InventoryBuilder(InventoryHolder holder, InventoryType type, String title) {
        inventory = Bukkit.createInventory(holder, type, title);
    }

    /**
     * setItem in Index
     * @param index Item Placed Index
     * @param stack Placed ItemStack
     * @return this
     */
    public InventoryBuilder setItem(int index, ItemStack stack) {
        inventory.setItem(index, stack);
        return this;
    }

    /**
     * setItem for Map
     * @param stackEntry key: ItemIndex value: ItemStack
     * @return this
     */
    public InventoryBuilder setItem(Map<Integer, ItemStack> stackEntry) {
        stackEntry.forEach(inventory::setItem);
        return this;
    }

    /**
     * filled Item
     * @param stack Filling Item
     * @return this
     */
    public InventoryBuilder fillItem(ItemStack stack) {
        inventory.all(stack);
        return this;
    }

    /**
     * add Items
     * @param stacks adding Items
     * @return this
     */
    public InventoryBuilder addItem(ItemStack... stacks) {
        inventory.addItem(stacks);
        return this;
    }

    /**
     * remove Item in Index
     * @param index removeItem index
     * @return this
     */
    public InventoryBuilder remove(int index) {
        inventory.clear(index);
        return this;
    }

    /**
     * remove Item of Material
     * @param material removing Material
     * @return this
     */
    public InventoryBuilder remove(Material material) {
        inventory.remove(material);
        return this;
    }

    /**
     * remove Item of ItemStack
     * @param stack removing ItemStack
     * @return this
     */
    public InventoryBuilder remove(ItemStack stack) {
        inventory.remove(stack);
        return this;
    }

    /**
     * clear Inventory
     * @return this
     */
    public InventoryBuilder clear() {
        inventory.clear();
        return this;
    }

    /**
     * check Contains Material
     * @param material checking Material
     * @return contains Material
     */
    public boolean contains(Material material) {
        return inventory.contains(material);
    }

    /**
     * check Contains ItemStack
     * @param stack checking ItemStack
     * @return contains ItemStack
     */
    public boolean contains(ItemStack stack) {
        return inventory.contains(stack);
    }

    /**
     * check Inventory on Empty
     * @return isEmpty
     */
    public boolean isEmpty() {
        return inventory.isEmpty();
    }

    /**
     * Inventory Size Getter
     * @return Inventory Size
     */
    public int getSize() {
        return inventory.getSize();
    }

    /**
     * get Index ItemStack
     * @param index getting Index
     * @return ItemStack
     */
    public ItemStack indexOf(int index) {
        return inventory.getItem(index);
    }

    /**
     * convert Inventory
     * @return Inventory
     */
    public Inventory toInventory() {
        return inventory;
    }

    /**
     * Inventory open Is Sync
     * @param player Inventory Open Player
     */
    public void openInventoryOfSync(Player player){
        Bukkit.getScheduler().runTask(FineLib.getPlugin(), () -> player.openInventory(inventory));
    }
}
