package pl.edu.pjwstk.s20265.mas.mp5.Inheritance;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class VinylRecord extends Record {
    @Id
    @GeneratedValue
    private Long id;

    private int rpm;

    public VinylRecord() {
    }

    public VinylRecord(String title, String artist, int rpm) {
        super(title, artist);
        this.rpm = rpm;
    }

    @Override
    public String toString() {
        return "VinylRecord{" +
                "rpm=" + rpm +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                "} ";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
