package io.github.tundraclimate.finelib.util.recipe;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;

/**
 * SharpedRecipe Modify
 */
public final class ShapedRecipeModifier implements RecipeModifier {
    private final ItemStack result;
    private final ShapedRecipe recipe;
    private final NamespacedKey key;

    /**
     * ShapedRecipe set Result and NameSpacedKey
     *
     * @param result Recipe Result
     * @param key    Recipe Key
     */
    public ShapedRecipeModifier(ItemStack result, NamespacedKey key) {
        this.result = result;
        this.key = key;
        this.recipe = new ShapedRecipe(getKey(), getResult());
    }

    @Override
    public ItemStack getResult() {
        return result;
    }

    @Override
    public void setRecipe(String... slot) {
        recipe.shape(slot);
    }

    /**
     * set Ingredient
     *
     * @param key        Ingredient key
     * @param ingredient setting Ingredient
     */
    public void setIngredient(char key, Material ingredient) {
        recipe.setIngredient(key, ingredient);
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
