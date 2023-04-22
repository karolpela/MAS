package models;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private String name;
    private Duration totalTime;
    private List<Equipment> equipment = new ArrayList<>();
    final List<RecipeIngredient> ingredients = new ArrayList<>(); // package private so that it's accessible in RecipeIngredient
    private List<Menu.MenuItem> items = new ArrayList<>();

    public Recipe(String name, Duration totalTime) {
        this.name = name;
        this.totalTime = totalTime;
    }

    public void addEquipment(Equipment equipment) {
        if (!this.equipment.contains(equipment)) {
            this.equipment.add(equipment);
            equipment.addRecipe(this);
        }
    }

    public void removeEquipment(Equipment equipment) {
        if (this.equipment.contains(equipment)) {
            this.equipment.remove(equipment);
            equipment.removeRecipe(this);
        }
    }

    public Iterable<Equipment> getEquipment() {
        return equipment;
    }

    public RecipeIngredient addIngredient(Ingredient ingredient, double amount, String unit) {
        return new RecipeIngredient(this, ingredient, amount, unit);
    }

    public void removeIngredient(Ingredient ingredient) {
        var recipeIngredient = this.ingredients.stream()
                .filter(ri -> ri.ingredient == ingredient)
                .findFirst();

        if (recipeIngredient.isEmpty())
            return;

        this.ingredients.remove(recipeIngredient.get());
        ingredient.recipes.remove(recipeIngredient.get());
    }

    public void addMenuItem(Menu.MenuItem menuItem) {
        if (!items.contains(menuItem)) {
            items.add(menuItem);
            menuItem.addRecipeQualified(this);
        }
    }

    public Iterable<RecipeIngredient> getIngredients() {
        return ingredients;
    }

    public String getName() {
        return name;
    }

    public Duration getTotalTime() {
        return totalTime;
    }

    @Override
    public String toString() {
        return name;
    }
}
