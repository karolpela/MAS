package bag;

import java.util.ArrayList;
import java.util.List;

public class Sportsman {
    private final String name;
    final List<Performance> performances = new ArrayList<>();

    public Sportsman(String name) {
        this.name = name;
    }

    public Performance addPerformance(Olympics olympics, int place, String competitionName) {
        return new Performance(olympics, this, place, competitionName);
    }

    public void removeRecipe(Olympics olympics) {
        var performance = this.performances.stream().filter(ri -> ri.olympics == olympics)
                .findFirst();

        if (performance.isEmpty()) {
            return;
        }

        this.performances.remove(performance.get());
        olympics.performances.remove(performance.get());
    }

    public Iterable<Olympics> getOlympics() {
        return performances
                .stream()
                .map(performance -> performance.olympics)
                .toList();
    }

    @Override
    public String toString() {
        return name;
    }
}
