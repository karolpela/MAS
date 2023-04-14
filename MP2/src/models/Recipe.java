package models;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private String name;
    private Duration totalTime;
    List<RecipeIngredient> ingredientList = new ArrayList<>();

    public Recipe(String name, Duration totalTime) {
        this.name = name;
        this.totalTime = totalTime;
    }

    public RecipeIngredient addIngredient(Ingredient ingredient, double amount, String unit) {
        return new RecipeIngredient(this, ingredient, amount, unit);
    }

    public void removeIngredient(Ingredient ingredient) {
        var recipeIngredient = this.ingredientList.stream()
                .filter(ri -> ri.ingredient == ingredient)
                .findFirst();

        if (recipeIngredient.isEmpty())
            return;

        this.ingredientList.remove(recipeIngredient.get());
        ingredient.recipeList.remove(recipeIngredient.get());
    }

    public Iterable<RecipeIngredient> getIngredientList() {
        return ingredientList;
    }

    @Override
    public String toString() {
        return name;
    }
}
