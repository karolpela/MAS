package bag;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class Olympics {
    private String hostCity;
    private Year year;
    final List<Performance> performances = new ArrayList<>(); // package private so that it's accessible in RecipeIngredient

    public Olympics(String hostCity, Year year) {
        this.hostCity = hostCity;
        this.year = year;
    }


    public Performance addPerformance(Sportsperson sportsperson, int place,
            String competitionName) {
        return new Performance(this, sportsperson, place, competitionName);
    }

    public void removePerformance(Performance performance) {
        if (this.performances.contains(performance)) {
            this.performances.remove(performance);
            performance.sportsman.removePerformance(performance);
        }
    }

    public Iterable<Performance> getPerformances() {
        return performances;
    }

    @Override
    public String toString() {
        return hostCity + " " + year;
    }
}
