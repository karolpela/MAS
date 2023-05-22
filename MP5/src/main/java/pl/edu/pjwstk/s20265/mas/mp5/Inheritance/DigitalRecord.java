package pl.edu.pjwstk.s20265.mas.mp5.Inheritance;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class DigitalRecord extends Record {
    public enum DigitalRecordType {CD, DVD}

    @Enumerated(EnumType.STRING)
    private DigitalRecordType recordType;

    public DigitalRecord() {
    }

    public DigitalRecord(String title, String artist, DigitalRecordType recordType) {
        super(title, artist);
        this.recordType = recordType;
    }

    @Override
    public String toString() {
        return "DigitalRecord{" +
                "recordType=" + recordType +
                "} " + super.toString();
    }
}
