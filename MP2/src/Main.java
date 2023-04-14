import models.Ingredient;
import models.Menu;
import models.Recipe;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var pasta = new Ingredient("Spaghetti pasta");
        var sauce = new Ingredient("Tomato sauce");
        var rosemary = new Ingredient("Rosemary");
        var beef = new Ingredient("Beef");
        var spaghettiBolognese = new Recipe("Spaghetti bolognese", Duration.ofMinutes(15));
        spaghettiBolognese.addIngredient(pasta, 150, "g");
        spaghettiBolognese.addIngredient(sauce, 100, "g");
        spaghettiBolognese.addIngredient(rosemary, 2, "sprig");
        spaghettiBolognese.addIngredient(beef, 50, "g");

        var lemon = new Ingredient("Lemon");
        var water = new Ingredient("Water");
        var iceCube = new Ingredient("Ice cube");
        var sugar = new Ingredient("Sugar");
        var lemonade = new Recipe("Lemonade", Duration.ofMinutes(5));
        lemonade.addIngredient(lemon, 0.5, null);
        lemonade.addIngredient(water, 400, "ml");
        lemonade.addIngredient(iceCube, 3, null);
        lemonade.addIngredient(sugar, 1, "teaspoon");

        var menu = new Menu("Lunch menu");
        menu.createMenuItem("Lunch set #1",
                BigDecimal.valueOf(10.99),
                List.of(spaghettiBolognese, lemonade));


        System.out.println("Menu:");
        System.out.println("\t" + menu);
        System.out.println("\tItems:" + menu.getItems());

        System.out.println("Recipe, Ingredient:");
        System.out.println("\t" + spaghettiBolognese + " - Ingredients:" + spaghettiBolognese.getIngredientList());
        System.out.println("\t" + beef + " - Recipes:" + beef.getRecipeList());

        System.out.println("Remove beef from spaghetti bolognese:");
        spaghettiBolognese.removeIngredient(beef);
        System.out.println("\t" + spaghettiBolognese + " - Ingredients:" + spaghettiBolognese.getIngredientList());
        System.out.println("\t" + beef + " - Recipes:" + beef.getRecipeList());
    }
}
