import java.util.ArrayList;
import java.util.List;

public class Equipment {
    private static final List<Equipment> allEquipment = new ArrayList<>();

    private double size;
    private String name;
    private Warehouse warehouse;

    public Equipment(double size, String name, Warehouse warehouse) {
        this.size = size;
        this.name = name;
        this.warehouse = warehouse;

        allEquipment.add(this);
    }

    public double getSize() {
        return size;
    }

    // Przeciążenie metody
    public double getSize(String system) throws IllegalArgumentException {
        return switch(system) {
            case "EU" -> size;
            case "US" -> size - 32;
            case "UK" -> size - 33;
        };
    }

    // Przesłonięcie metody
    @Override
    public String toString() {
        return name + " - size:" + size;
    }
}
