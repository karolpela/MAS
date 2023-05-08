package bag;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Olympics {
    private String hostCity;
    private LocalDateTime year;
    final List<Performance> performances = new ArrayList<>(); // package private so that it's accessible in RecipeIngredient

    public Olympics(String hostCity, LocalDateTime year) {
        this.hostCity = hostCity;
        this.year = year;
    }


    public Performance addIngredient(Sportsman sportsman, int amount, String unit) {
        return new Performance(this, sportsman, amount, unit);
    }


    public Iterable<Performance> getPerformances() {
        return performances;
    }

    public String getHostCity() {
        return hostCity;
    }

    public LocalDateTime getYear() {
        return year;
    }

    @Override
    public String toString() {
        return hostCity + " " + year;
    }
}
