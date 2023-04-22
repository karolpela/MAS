package models;

import java.util.ArrayList;
import java.util.List;

public class Equipment {
    private String name;

    private List<Recipe> recipes = new ArrayList<>();

    public Equipment(String name) {
        this.name = name;
    }

    public void addRecipe(Recipe recipe) {
        if (!recipes.contains(recipe)) {
            recipes.add(recipe);
            recipe.addEquipment(this);
        }
    }

    public void removeRecipe(Recipe recipe) {
        if (recipes.contains(recipe)) {
            recipes.remove(recipe);
            recipe.removeEquipment(this);
        }
    }

    public Iterable<Recipe> getRecipes() {
        return recipes;
    }

    @Override
    public String toString() {
        return name;
    }
}
