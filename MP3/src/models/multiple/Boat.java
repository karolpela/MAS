package models.multiple;

import interfaces.Sailable;

public class Boat extends MotorVehicle implements Sailable {
    private int turbineCount;

    public Boat(Integer passengerCount, Double engineCapacity, Double fuelInTank, Double posX, Double posY, int turbineCount) {
        super(passengerCount, engineCapacity, fuelInTank, posX, posY);
        this.turbineCount = turbineCount;
    }

    @Override
    public int getTurbineCount() {
        return turbineCount;
    }

    @Override
    public void sailTo(Destination destination) throws Exception {
        if (destination.getType() != DestinationType.Water) {
            throw new Exception("Can't drive to a non-ground destination");
        }
        moveTo(destination);
        System.out.printf("Sailed to: %s, remaining fuel: %.2f\n", destination, fuelInTank);
    }

    @Override
    public double calculateFuelNeeded(double kilometers) {
        return super.getEngineCapacity() * 0.0001  * kilometers * ((double) turbineCount / 10);
    }
}
