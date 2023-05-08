package bag;


// Many-to-many with attributes
public class Performance {
    Olympics olympics;
    Sportsman sportsman;
    private String competitionName;
    private int place;

    public Performance(Olympics olympics, Sportsman sportsman, int amount,
            String competitionName) {
        this.olympics = olympics;
        this.sportsman = sportsman;
        this.place = amount;
        this.competitionName = competitionName;

        olympics.performances.add(this);
        sportsman.performances.add(this);
    }

    @Override
    public String toString() {
        return sportsman + " - " + place + " place in " + competitionName;
    }
}
