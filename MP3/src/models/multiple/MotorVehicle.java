package models.multiple;

public abstract class MotorVehicle {
    private Integer passengerCount;
    private Double engineCapacity;
    protected Double fuelInTank;

    protected Double posX;
    protected Double posY; // easily modified in subclasses but not from the outside

    public MotorVehicle(Integer passengerCount, Double engineCapacity, Double fuelInTank, Double posX, Double posY) {
        this.passengerCount = passengerCount;
        this.engineCapacity = engineCapacity;
        this.fuelInTank = fuelInTank;
        this.posX = posX;
        this.posY = posY;
    }

    public abstract double calculateFuelNeeded(double kilometers);

    public Double getEngineCapacity() {
        return engineCapacity;
    }

    protected void moveTo(Destination destination) throws Exception {
        var distance = destination.calculateDistance(posX, posY);

        var fuelNeeded = calculateFuelNeeded(distance);
        if (fuelNeeded > fuelInTank) {
            throw new Exception("Not enough fuel");
        }
        posX = destination.getX();
        posY = destination.getY();
        fuelInTank -= fuelNeeded;
    }
}
