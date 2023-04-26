package models.multiple;

public class Car extends MotorVehicle {
    private int wheelCount;

    public Car(Integer passengerCount, Double engineCapacity, Double fuelInTank, Double posX, Double posY, int wheelCount) {
        super(passengerCount, engineCapacity, fuelInTank, posX, posY);
        this.wheelCount = wheelCount;
    }

    public void driveTo(Destination destination) throws Exception {
        if (destination.getType() != DestinationType.Ground) {
            throw new Exception("Can't drive to a non-ground destination");
        }
        moveTo(destination);
        System.out.printf("Drove to: %s, remaining fuel: %.2f\n", destination, fuelInTank);
    }

    @Override
    public double calculateFuelNeeded(double kilometers) {
        return super.getEngineCapacity() * 0.0001 * kilometers * ((double) wheelCount / 2);
    }
}
