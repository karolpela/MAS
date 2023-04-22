package models;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Ingredient {
    private final String name;
    final List<RecipeIngredient> recipes = new ArrayList<>();

    public Ingredient(String name) {
        this.name = name;
    }

    public RecipeIngredient addRecipe(Recipe recipe, int amount, @Nullable String unit) {
        return new RecipeIngredient(recipe, this, amount, unit);
    }

    public void removeRecipe(Recipe recipe) {
        var recipeIngredient = this.recipes.stream().filter(ri -> ri.recipe == recipe).findFirst();

        if (recipeIngredient.isEmpty()) return;

        this.recipes.remove(recipeIngredient.get());
        recipe.ingredients.remove(recipeIngredient.get());
    }

    public Iterable<Recipe> getRecipes() {
        return recipes
                .stream()
                .map(recipeIngredient -> recipeIngredient.recipe)
                .toList();
    }

    @Override
    public String toString() {
        return name;
    }
}
