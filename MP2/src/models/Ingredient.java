package models;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Ingredient {
    private String name;
    List<RecipeIngredient> recipeList = new ArrayList<>();

    public Ingredient(String name) {
        this.name = name;
    }

    public RecipeIngredient addRecipe(Recipe recipe, int amount, @Nullable String unit) {
        return new RecipeIngredient(recipe, this, amount, unit);
    }

    public void removeRecipe(Recipe recipe) {
        var recipeIngredient = this.recipeList.stream().filter(ri -> ri.recipe == recipe).findFirst();

        if (recipeIngredient.isEmpty()) return;

        this.recipeList.remove(recipeIngredient.get());
        recipe.ingredientList.remove(recipeIngredient.get());
    }

    public Iterable<Recipe> getRecipeList() {
        return recipeList
                .stream()
                .map(recipeIngredient -> recipeIngredient.recipe)
                .toList();
    }

    @Override
    public String toString() {
        return name;
    }
}
