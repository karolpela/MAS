package models.multiaspect;

public abstract class Record {
    private String title;
    private String artist;
    private RecordGenre genre;
    private Integer bpm; // electronic only
    private String orchestraName; // orchestral only

    public Record(String title, String artist, RecordGenre genre, Integer bpm, String orchestraName) throws Exception {
        if (genre == null) {
            throw new Exception("Record has to have a genre!");
        }
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.bpm = bpm;
        this.orchestraName = orchestraName;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public Integer getBpm() throws Exception {
        if (this.genre != RecordGenre.Electronic) {
            throw new Exception("Non-electronic records don't have BPM!");
        }
        return bpm;
    }

    public String getOrchestraName() throws Exception {
        if (this.genre != RecordGenre.Orchestral) {
            throw new Exception("Non-orchestral records don't have a orchestra name!");
        }
        return orchestraName;
    }

    public abstract void play() throws Exception;
}
