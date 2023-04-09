import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

public class Patron implements Serializable {
    // -- Ekstensja
    // Niefinalna ze względu na deserializację
    private static List<Patron> extent = new ArrayList<>();

    // -- Atrybut wymagany
    private @NotNull String firstName;
    private @NotNull String lastName;

    // -- Atrybut powtarzalny
    private @NotNull List<String> allergies;

    // -- Atrybut opcjonalny
    private @Nullable String dietaryPreferences;

    // -- Atrybut złożony
    private final @NotNull LocalDateTime profileCreationDateTime;

    // -- Atrybut klasowy
    public static final int MIN_ALLERGIES_FOR_SPECIAL_ATTENTION = 3;

    // -- Przeciążenie
    public Patron(@NotNull String firstName, @NotNull String lastName, @Nullable String dietaryPreferences, List<String> allergies) {
        this.firstName = firstName;
        this.lastName = lastName;
        // Tworzę nową listę, ponieważ dostarczona może być niemodyfikowalna,
        // a lista alergii może potencjalnie okazać się konieczna do zaktualizowania w przyszłości.
        this.allergies = new ArrayList<>(allergies);
        this.dietaryPreferences = dietaryPreferences;
        this.profileCreationDateTime = LocalDateTime.now();
        extent.add(this);
    }

    public Patron(@NotNull String firstName, @NotNull String lastName, @Nullable String dietaryPreferences) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.allergies = new ArrayList<>();
        this.dietaryPreferences = dietaryPreferences;
        this.profileCreationDateTime = LocalDateTime.now();
        extent.add(this);
    }

    public Patron(@NotNull String firstName, @NotNull String lastName, List<String> allergies) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.allergies = new ArrayList<>(allergies);
        this.profileCreationDateTime = LocalDateTime.now();
        extent.add(this);
    }

    // -- Atrybut klasowy
    public boolean needsSpecialAttention() {
        return allergies.size() >= MIN_ALLERGIES_FOR_SPECIAL_ATTENTION;
    }

    // -- Atrybut wyliczalny
    public Set<String> getForbiddenProducts() {
        var forbiddenProducts = new HashSet<String>();
        for (String allergy : allergies) {
            forbiddenProducts.addAll(
                    switch (allergy) {
                        case "eggs" -> Arrays.asList("eggs", "eggnog", "cake");
                        case "milk" -> Arrays.asList("milk", "white cheese", "cream");
                        default -> Arrays.asList("No products defined for allergy (" + allergy + ")");
                    }
            );
        }
        return forbiddenProducts;
    }

    // -- Przesłonięcie
    @Override
    public String toString() {
        return "Patron: " + firstName + " " + lastName + ";" +
                "Allergies: " + (allergies.isEmpty() ? "none" : allergies) + ";" +
                "Dietary preferences: " + (dietaryPreferences == null ? "none" : dietaryPreferences) +
                (needsSpecialAttention() ? ";Needs special attention!" : "");
    }

    /**
     * @return A map with dietetary preferences as keys and count of respective patrons as values
     */
    // -- Metoda klasowa
    public static Map<String, Integer> getDietaryPreferencesStatistics() {
        var preferenceMap = new HashMap<String, Integer>();
        extent.forEach(patron -> {
            var preferences = patron.dietaryPreferences == null ? "none" : patron.dietaryPreferences;
            preferenceMap.merge(preferences, 1, Integer::sum);
        });
        return preferenceMap;
    }

    // Metody zapewniające trwałość ekstensji
    // Jako argument ogólnie podajemy strumień ze względu na większą swobodę,
    // np. zapis wielu plików do tego samego strumienia
    public static void writeExtent(ObjectOutputStream stream) throws IOException {
        stream.writeObject(extent);
    }

    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        extent = (ArrayList<Patron>) stream.readObject();
    }

    // Metody pomocnicze
    public static void showExtent() {
        // class.getName() zapewnia łatwiejszy refactoring
        System.out.println("Extent of the class: " + Patron.class.getName());
        extent.forEach(System.out::println);
    }

    public static void clearExtent() {
        extent = new ArrayList<>();
    }

    public static Iterable<Patron> getExtent() {
        return extent;
    }

    // Gettery/settery

    public @NotNull String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null) throw new IllegalArgumentException();
        this.firstName = firstName;
    }

    public @NotNull String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null) throw new IllegalArgumentException();
        this.lastName = lastName;
    }

    public @NotNull List<String> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<String> allergies) {
        if (allergies == null) throw new IllegalArgumentException();
        this.allergies = allergies;
    }

    public Optional<String> getDietaryPreferences() {
        return Optional.ofNullable(dietaryPreferences);
    }

    public void setDietaryPreferences(@Nullable String dietaryPreferences) {
        this.dietaryPreferences = dietaryPreferences;
    }

    public @NotNull LocalDateTime getProfileCreationDateTime() {
        return profileCreationDateTime;
    }
}