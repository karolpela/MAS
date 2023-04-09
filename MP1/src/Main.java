import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class Main {
    final static String extentFile = "/Users/karol/MP1_extent.txt";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("# Wypisanie pustej ekstensji:");
        Patron.showExtent();
        System.out.println("# Stworzenie gości");
        createPatrons();
        System.out.println("# Wypisanie listy gości:");
        Patron.showExtent();
        System.out.println("# Zapisanie listy gości do pliku");
        savePatrons();
        System.out.println("# Wyczyszczenie ekstensji");
        Patron.clearExtent();
        System.out.println("# Wypisanie pustej ekstensji:");
        Patron.showExtent();
        System.out.println("# Wczytanie ekstensji");
        readPatrons();
        System.out.println("# Wypisanie ekstensji:");
        Patron.showExtent();
        System.out.println("# Atrybut opcjonalny:");
        for (Patron p : Patron.getExtent()) {
            System.out.println(p.getFirstName() + " " + p.getLastName() +
                    ": " + p.getDietaryPreferences().orElse("(no specific preferences)"));
        }
        System.out.println("# Atrybut klasowy:");
        for (Patron p : Patron.getExtent()) {
            System.out.println(p.getFirstName() + " " + p.getLastName() +
                    ": " + (p.getAllergies().size() >= Patron.MIN_ALLERGIES_FOR_SPECIAL_ATTENTION ? "Needs special attention!" : ""));
        }
        System.out.println("# Atrybut wyliczalny:");
        for (Patron p : Patron.getExtent()) {
            System.out.println(p.getFirstName() + " " + p.getLastName() +
                    " Forbidden products: " + (p.getForbiddenProducts()));
        }
        System.out.println("# Atrybut złożony:");
        for (Patron p : Patron.getExtent()) {
            System.out.println(p.getFirstName() + " " + p.getLastName() +
                    " created at: " + p.getProfileCreationDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        }
        System.out.println("# Metoda klasowa");
        System.out.println("Number of patrons per dietary preference:");
        System.out.println(Patron.getDietaryPreferencesStatistics());
    }


    @SuppressWarnings("unused")
    private static void createPatrons() {
        var patron1 = new Patron("Jan", "Kowalski", List.of("peanuts"));
        var patron2 = new Patron("Adam", "Nowak", "vegetarian");
        var patron3 = new Patron("Grzegorz", "Brzęczyszczykiewicz",
                "pescatarian", Arrays.asList("milk", "eggs"));
        var patron4 = new Patron("Piotr", "Pawłowski", Arrays.asList("peanuts", "milk", "eggs", "oranges"));
    }

    private static void savePatrons() throws IOException {
        try (var out = new ObjectOutputStream(new FileOutputStream(extentFile))) {
            Patron.writeExtent(out);
        }
    }

    private static void readPatrons() throws IOException, ClassNotFoundException {
        try (var in = new ObjectInputStream(new FileInputStream(extentFile))) {
            Patron.readExtent(in);
        }
    }
}
