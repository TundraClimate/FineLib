package com.tundra.finelib.util.recipe;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;

/**
 * Recipe Modify interface
 */
public interface RecipeModifier {
    /**
     * recipe result getter
     * @return recipe Result
     */
    ItemStack getResult();

    /**
     * recipe setter
     * @param slot Recipe
     */
    void setRecipe(String... slot);

    /**
     * recipe getter
     * @return recipe
     */
    Recipe getRecipe();

    /**
     * NameSpacedKey getter
     * @return recipe NameSpacedKey
     */
    NamespacedKey getKey();

    /**
     * register Recipe
     */
    void register();
}
