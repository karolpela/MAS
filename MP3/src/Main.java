import interfaces.Sailable;
import models.dynamic.RentalSpace;
import models.multiaspect.DigitalRecord;
import models.multiaspect.Record;
import models.multiaspect.RecordGenre;
import models.multiaspect.VinylRecord;
import models.multiple.*;
import models.overlapping.Building;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n>>> Multiple inheritance");
        var car = new Car(4, 200.0, 4000.0, 0.0, 0.0, 4);
        var boat = new Boat(2, 300.0, 7000.0, 0.0, 0.0, 3);
        var amphibian = new Amphibian(6, 400, 10000.0, 0.0, 0.0, 4, 4);
        var destinationWater = new Destination("Harbor", 100.0, 100.0, DestinationType.Water);
        var destinationGround = new Destination("Hangar", -100.0, -100.0, DestinationType.Ground);

        var sailables = List.of(boat, amphibian);
        var cars = List.of(car, amphibian);

        try {
            System.out.println("> Car:");
            car.driveTo(destinationGround);
            System.out.println("> Boat:");
            boat.sailTo(destinationWater);
            System.out.println("> Amphibian:");
            amphibian.sailTo(destinationWater);
            amphibian.driveTo(destinationGround);
            amphibian.sailTo(destinationWater);
            System.out.println("> Attempt to drive the car to a water destination");
            car.driveTo(destinationWater);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("> Demonstrate polymorphism");
        try {
            for (Sailable s : sailables) {
                s.sailTo(destinationWater);
            }
            for (Car c : cars) {
                c.driveTo(destinationGround);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n>>> Overlapping inheritance");
        var building = new Building(3);
        System.out.println(building);
        try {
            System.out.println("> Try to check if pets are allowed");
            System.out.println("Are pets allowed? " + (building.arePetsAllowed() ? "yes" : "no"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("> Create a residential building, try again");
            var residentialBuilding = Building.createResidential(4, true);
            System.out.println("Are pets allowed? " + (residentialBuilding.arePetsAllowed() ? "yes" : "no"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("> Make a commercial building");
            var commercialBuilding = Building.createCommercial(3, 42);
            System.out.println(commercialBuilding);
            System.out.println("> Try to check if pets are allowed");
            System.out.println("Are pets allowed? " + (commercialBuilding.arePetsAllowed() ? "yes" : "no"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("> Create a residential-commercial building");
            var residentialCommercial = Building.createResidentialCommercial(3, 44, false);
            System.out.println("Number of workers: " + residentialCommercial.getWorkerCount());
            System.out.println("Are pets allowed? " + (residentialCommercial.arePetsAllowed() ? "yes" : "no"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n>>> Dynamic inheritance");
        System.out.println("> Create a rental space");
        var rentalSpace = new RentalSpace(new BigDecimal("3000"));
        System.out.println(rentalSpace);
        try {
            System.out.println("> Try to check store name");
            System.out.println("Name of the store: " + rentalSpace.getStoreName());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("> Make the space retail space, try again");
            rentalSpace.makeRetail("The M.A.S. Store");
            System.out.println("Name of the store: " + rentalSpace.getStoreName());
            System.out.println("> Try to check worker count");
            System.out.println("Number of workers: " + rentalSpace.getWorkerCount());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("> Make the space office space, try again");
            rentalSpace.makeOffice(33);
            System.out.println("Number of workers: " + rentalSpace.getWorkerCount());
            System.out.println("> Make the space unrented, try to check worker count");
            rentalSpace.makeUnrented();
            System.out.println(rentalSpace);
            System.out.println("Number of workers: " + rentalSpace.getWorkerCount());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n>>> Multiaspect inheritance");
        List<Record> allRecords = Collections.emptyList();
        try {
            Record digitalElectronic = new DigitalRecord("Four", "Joris Voorn",
                    RecordGenre.Electronic, 100, "CD");
            Record digitalOrchestral = new DigitalRecord("The Four Seasons", "Antonio Vivaldi",
                    RecordGenre.Orchestral, "Wiener Philharmoniker", "Blu-Ray");
            Record vinylElectronic = new VinylRecord("Random Friday", "Solar Fields",
                    RecordGenre.Electronic, 130, 33);
            Record vinylOrchestral = new VinylRecord("Johannes Brahms", "Four Symphonies",
                    RecordGenre.Orchestral, "Dresden State Orchestra", 45);
            allRecords = List.of(digitalElectronic, digitalOrchestral, vinylElectronic, vinylOrchestral);
            System.out.println("> Check BPM of 1st record");
            System.out.println("BPM: " + digitalElectronic.getBpm());
            System.out.println("> Try to check orchestra name of 1st record");
            System.out.println("Orchestra name: " + digitalElectronic.getOrchestraName());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("> Demonstrate polymorphism");
        for (Record allRecord : allRecords) {
            try {
                allRecord.play();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}