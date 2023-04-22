package models;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.*;

// Composition
public class Menu {
    private String name;
    private List<MenuItem> items = new ArrayList<>();

    public Menu(String name) {
        this.name = name;
    }

    public MenuItem createMenuItem(String name, BigDecimal price, Collection<Recipe> recipes) {
        var menuItem = new MenuItem(name, price);
        recipes.forEach(menuItem::addRecipeQualified);
        this.items.add(menuItem);
        return menuItem;
    }

    public Iterable<MenuItem> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return name;
    }

    public class MenuItem {
        public static final NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        private final String name;
        private final BigDecimal price;

        // No need for a reference to Menu - accessible by Menu.this

        // Qualified association
        private final Map<String, Recipe> recipesQualified = new HashMap<>();

        // One item might consist of several elements which have individual recipes,
        // e.g. menu item is "Lunch set #3": baked potatoes + smoked salmon + roasted asparagus.
        // Business case: client orders "Lunch set #3" and the chef needs all the recipes needed to prepare it.
        // Name of the recipe is the qualifier in this case.

        public void addRecipeQualified(Recipe recipe) {
            if (!recipesQualified.containsKey(recipe.getName())) {
                recipesQualified.put(recipe.getName(), recipe);
                recipe.addMenuItem(this);
            }
        }

        public Recipe findRecipeQualified(String recipeName) throws Exception {
            if (!recipesQualified.containsKey(recipeName)) {
                throw new Exception("Unable to find recipe \"" + recipeName + "\"");
            }
            return recipesQualified.get(recipeName);
        }

        public List<Recipe> getRecipes() {
            return new ArrayList<>(recipesQualified.values());
        }

        // Any reason to not make this private? @mtrzaska
        public MenuItem(String name, BigDecimal price) {
            this.name = name;
            this.price = price;
        }

        public Menu getMenu() {
            return Menu.this;
        }

        @Override
        public String toString() {
            return name + " " + currencyFormat.format(price);
        }
    }
}
