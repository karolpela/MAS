package xor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Sentence {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String crime;
    private Citizen citizen;

    public Sentence(LocalDateTime startDate, LocalDateTime endDate, String crime, Citizen citizen) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.crime = crime;
        this.citizen = citizen;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        return crime + " " + formatter.format(startDate) + "-" + formatter.format(endDate);
    }
}
