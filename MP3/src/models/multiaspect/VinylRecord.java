package models.multiaspect;

public class VinylRecord extends Record {
    private int rpm;

    // Electronic vinyl record
    public VinylRecord(String title, String artist, RecordGenre genre, Integer bpm, int rpm) throws Exception {
        super(title, artist, genre, bpm, null);
        this.rpm = rpm;
    }

    // Orchestral vinyl record
    public VinylRecord(String title, String artist, RecordGenre genre, String orchestraName, int rpm) throws Exception {
        super(title, artist, genre, null, orchestraName);
        this.rpm = rpm;
    }

    public int getRpm() {
        return rpm;
    }

    @Override
    public void play() throws Exception {
        System.out.println("♪♫ Playing a vinyl record: " + this.getTitle() + " by " + this.getArtist() + ", rpm: " + this.getRpm() + " ♫♪");
    }
}
