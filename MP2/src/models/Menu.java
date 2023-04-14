package models;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Currency;
import java.util.List;

// Composition
public class Menu {
    private String name;
    private List<MenuItem> items = new ArrayList<>();

    public Menu(String name) {
        this.name = name;
    }

    public MenuItem createMenuItem(String name, BigDecimal price, Collection<Recipe> recipes) {
        var menuItem = new MenuItem(name, price, recipes);
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
        public static NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        private String name;
        private BigDecimal price;

        // No need for a reference to Menu - accessible by Menu.this

        // One item might consist of several elements which have individual recipes,
        // e.g. menu item is "Lunch set #3": baked potatoes + smoked salmon + roasted asparagus.
        // Business case: client orders "Lunch set #3" and the chef needs all the recipes needed to prepare it.
        // Name of the recipe is the qualifier in this case.
        List<Recipe> recipeList = new ArrayList<>();

        // Any reason to not make this private? @mtrzaska
        public MenuItem(String name, BigDecimal price, Collection<Recipe> recipes) {
            this.name = name;
            this.price = price;
            recipeList.addAll(recipes);
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
