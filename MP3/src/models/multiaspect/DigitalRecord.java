package models.multiaspect;

public class DigitalRecord extends Record {
    private String mediaType;

    // Electronic digital record
    public DigitalRecord(String title, String artist, RecordGenre genre,Integer bpm, String mediaType) throws Exception {
        super(title, artist, genre, bpm, null);
        this.mediaType = mediaType;
    }

    // Orchestral digital record
    public DigitalRecord(String title, String artist, RecordGenre genre, String orchestraName, String mediaType) throws Exception {
        super(title, artist, genre,null, orchestraName);
        this.mediaType = mediaType;
    }

    public String getMediaType() {
        return mediaType;
    }

    @Override
    public void play() throws Exception {
        System.out.println("♪♫ Playing a digital record: " + this.getTitle() + " by " + this.getArtist() + ", media type: " + this.getMediaType() + " ♫♪");
    }
}
