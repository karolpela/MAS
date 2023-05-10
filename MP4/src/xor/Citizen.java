package xor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Citizen {
    private String name;

    private Immunity immunity;
    private final Set<Sentence> sentences = new HashSet<>();

    public Citizen(String name) {
        this.name = name;
    }

    public void addSentence(LocalDateTime startDate, LocalDateTime endDate, String crime) {
        if (this.immunity != null) {
            System.out.println("Cannot give scholarship to a citizen with immunity!");
            return;
        }
        this.sentences.add(new Sentence(startDate, endDate, crime, this));
    }

    public void clearSentences() {
        this.sentences.clear();
    }

    public void addImmunity(String kind) {
        if (!this.sentences.isEmpty()) {
            System.out.println("Cannot immunity to a citizen with an active sentence!");
            return;
        }
        this.immunity = new Immunity(kind, this);
    }

    public void removeImmunity() {
        this.immunity = null;
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "name='" + name + '\'' +
                ", immunity=" + immunity +
                ", sentences=" + sentences +
                '}';
    }
}
