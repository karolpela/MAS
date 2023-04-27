package models.overlapping;

import java.util.EnumSet;
import java.util.Set;

enum buildingType {Building, Commercial, Residential}

public class Building {
    // General building
    private int floorCount;
    // Commercial
    private Integer workerCount;
    // Residential
    private Boolean petsAllowed;

    private final EnumSet<buildingType> typeSet = EnumSet.of(buildingType.Building);

    public Building(int floorCount) {
        this.floorCount = floorCount;
    }

    // Methods are used to create instances due to the enum being contained
    // in the same .java file, which makes it inaccessible from the outside,
    // and also to avoid ambiguity between constructors.
    // This also gives more control as you can't add a new value to the enum
    // and try to pass it in a constructor.

    public static Building createCommercial(int floorCount, int workerCount) {
        var building = new Building(floorCount);
        building.typeSet.add(buildingType.Residential);
        building.workerCount = workerCount;
        return building;
    }

    public static Building createResidential(int floorCount, boolean petsAllowed) {
        var building = new Building(floorCount);
        building.typeSet.add(buildingType.Commercial);
        building.petsAllowed = petsAllowed;
        return building;
    }

    public static Building createResidentialCommercial(int floorCount, int workerCount, boolean petsAllowed) {
        var building = new Building(floorCount);
        building.typeSet.add(buildingType.Residential);
        building.typeSet.add(buildingType.Commercial);
        building.workerCount = workerCount;
        building.petsAllowed = petsAllowed;
        return building;
    }


    public int getWorkerCount() throws Exception {
        if (typeSet.contains(buildingType.Residential)) {
            return workerCount;
        } else {
            throw new Exception("The building is not a commercial building!");
        }
    }

    public boolean arePetsAllowed() throws Exception {
        if (typeSet.contains(buildingType.Commercial)) {
            return petsAllowed;
        } else {
            throw new Exception("The building is not a residential building!");
        }
    }

    @Override
    public String toString() {
        if (typeSet.containsAll(Set.of(buildingType.Residential, buildingType.Commercial))) {
            return "Residential-commercial building" +
                    ", floor count: " + floorCount +
                    ", pets allowed: " + (petsAllowed ? "yes" : "no") +
                    ", worker count: " + workerCount;
        } else if (typeSet.contains(buildingType.Residential)) {
            return "Commercial building" +
                    ", floor count: " + floorCount +
                    ", worker count: " + workerCount;
        } else if (typeSet.contains(buildingType.Commercial)) {
            return "Residential building" +
                    ", floor count: " + floorCount +
                    ", pets allowed: " + (petsAllowed ? "yes" : "no");
        } else {
            return "Building" +
                    ", floor count: " + floorCount;
        }
    }
}
