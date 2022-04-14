package io.github.tundraclimate.finelib.util.recipe;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;

/**
 * Shapeless Recipe Modify
 */
public class ShapelessRecipeModifier implements RecipeModifier {
    private final ItemStack result;
    private final ShapelessRecipe recipe;
    private final NamespacedKey key;

    /**
     * ShapelessRecipe set Result and NameSpacedKey
     *
     * @param result Recipe result
     * @param key    Recipe key
     */
    public ShapelessRecipeModifier(ItemStack result, NamespacedKey key) {
        this.result = result;
        this.key = key;
        this.recipe = new ShapelessRecipe(getKey(), getResult());
    }

    @Override
    public ItemStack getResult() {
        return result;
    }

    @Deprecated
    @Override
    public void setRecipe(String... slot) {
    }

    /**
     * add Ingredient
     *
     * @param ingredient adding Ingredient
     */
    public void addIngredient(Material ingredient) {
        recipe.addIngredient(ingredient);
    }

    @Override
    public Recipe getRecipe() {
        return recipe;
    }

    @Override
    public NamespacedKey getKey() {
        return key;
    }

    @Override
    public void setGroup(String group) {
        recipe.setGroup(group);
    }

    @Override
    public void register() {
        Bukkit.addRecipe(recipe);
    }
}
