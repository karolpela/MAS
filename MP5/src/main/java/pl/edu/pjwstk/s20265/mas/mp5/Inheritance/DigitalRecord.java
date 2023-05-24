package pl.edu.pjwstk.s20265.mas.mp5.Inheritance;

import jakarta.persistence.*;

@Entity
public class DigitalRecord extends Record {
    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private DigitalRecordType recordType;

    public DigitalRecord() {
    }

    public DigitalRecord(String title, String artist, DigitalRecordType recordType) {
        super(title, artist);
        this.recordType = recordType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "DigitalRecord{" +
                "recordType=" + recordType +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                "} ";
    }

    public enum DigitalRecordType {CD, DVD}
}
