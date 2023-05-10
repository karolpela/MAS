package xor;

public class Immunity {
    private String kind;
    private Citizen citizen;

    public Immunity(String kind, Citizen citizen) {
        this.kind = kind;
        this.citizen = citizen;
    }

    @Override
    public String toString() {
        return kind + " immunity";
    }
}
