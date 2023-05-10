package bag;

import java.util.ArrayList;
import java.util.List;

public class Sportsperson {
    private final String name;
    final List<Performance> performances = new ArrayList<>();

    public Sportsperson(String name) {
        this.name = name;
    }

    public Performance addPerformance(Olympics olympics, int place, String competitionName) {
        return new Performance(olympics, this, place, competitionName);
    }

    public void removePerformance(Performance performance) {
        if (this.performances.contains(performance)) {
            this.performances.remove(performance);
            performance.olympics.removePerformance(performance);
        }
    }

    public Iterable<Performance> getPerformances() {
        return performances;
    }

    @Override
    public String toString() {
        return name;
    }
}
