package pl.edu.pjwstk.s20265.mas.mp5.Inheritance;

import jakarta.persistence.Entity;

@Entity
public class VinylRecord extends Record {
    private int rpm;

    public VinylRecord() {
    }

    public VinylRecord(String title, String artist, int rpm) {
        super(title, artist);
        this.rpm = rpm;
    }
}
