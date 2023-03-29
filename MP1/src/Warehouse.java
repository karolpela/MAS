import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    private static final List<Warehouse> allWarehouses = new ArrayList<>();

    private String type;
    private String address;
    private int capacity;

    private final List<Equipment> equipmentList;

    public Warehouse(String type, String address, int capacity) {
        this.type = type;
        this.address = address;
        this.capacity = capacity;

        equipmentList = new ArrayList<>();

        allWarehouses.add(this);
    }

    // Atrybut pochodny
    public int getRemainingCapacity() {
        return capacity - equipmentList.size();
    }
}
