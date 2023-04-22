import models.Equipment;
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


        var bigPot = new Equipment("Big pot");
        var fryingPan = new Equipment("Frying pan");
        spaghettiBolognese.addEquipment(bigPot);
        spaghettiBolognese.addEquipment(fryingPan);

        var glass = new Equipment("Big glass");
        var straw = new Equipment("Straw");
        glass.addRecipe(lemonade);
        straw.addRecipe(lemonade);


        var menu = new Menu("Lunch menu");
        var menuItem1 = menu.createMenuItem("Lunch set #1",
                BigDecimal.valueOf(10.99),
                List.of(spaghettiBolognese, lemonade));

        System.out.println("\n-> Menu (composition):");
        System.out.println(menu);
        System.out.println("Items:" + menu.getItems());

        System.out.println("\n-> Recipe, Ingredient (many-to-many with attributes):");
        System.out.println(spaghettiBolognese + ", ingredients:" + spaghettiBolognese.getIngredients());
        System.out.println(beef + ", recipes:" + beef.getRecipes());

        System.out.println("\n-> Remove beef from spaghetti bolognese:");
        spaghettiBolognese.removeIngredient(beef);
        System.out.println(spaghettiBolognese + ", ingredients:" + spaghettiBolognese.getIngredients());
        System.out.println(beef + ", recipes:" + beef.getRecipes());

        System.out.println("\n-> MenuItem, Recipe (qualified):");
        System.out.println(menuItem1);
        System.out.println("Recipes:" + menuItem1.getRecipes());
        try {
            var find1 = menuItem1.findRecipeQualified("Lemonade");
            System.out.println(find1
                    + ", time: " + find1.getTotalTime().toMinutes() + " min"
                    + ", ingredients:" + find1.getIngredients());
            var find2 = menuItem1.findRecipeQualified("Pancakes");
            System.out.println(find2
                    + ", time: " + find2.getTotalTime().toMinutes()
                    + " min" + ", ingredients:" + find2.getIngredients());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n-> Equipment, Recipe (many-to-many regular):");
        System.out.println(spaghettiBolognese + ", equipment: " + spaghettiBolognese.getEquipment());
        System.out.println(lemonade + ", equipment: " + lemonade.getEquipment());
        System.out.println(straw + ", recipes: " + straw.getRecipes());

        System.out.println("\n-> Remove straw from lemonade:");
        lemonade.removeEquipment(straw);
        System.out.println(lemonade + ", equipment: " + lemonade.getEquipment());
        System.out.println(straw + ", recipes: " + straw.getRecipes());
    }
}
