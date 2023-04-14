package models;

import org.jetbrains.annotations.Nullable;

// Many-to-many with attributes
public class RecipeIngredient {
    Recipe recipe;
    Ingredient ingredient;
    private double amount;
    private @Nullable String unit;

    public RecipeIngredient(Recipe recipe, Ingredient ingredient, double amount, @Nullable String unit) {
        this.recipe = recipe;
        this.ingredient = ingredient;
        this.amount = amount;
        this.unit = unit;

        recipe.ingredientList.add(this);
        ingredient.recipeList.add(this);
    }

    @Override
    public String toString() {
        return ingredient + " " + amount + " " + unit;
    }
}
