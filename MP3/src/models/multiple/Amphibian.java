package models.multiple;

import interfaces.Sailable;

public class Amphibian extends Car implements Sailable {
    private Boat boat;

    public Amphibian(int passengerCount, double engineCapacity, double fuelInTank, double posX, double posY, int wheelCount, int turbineCount) {
        super(passengerCount, engineCapacity, fuelInTank, posX, posY, wheelCount);
        this.boat = new Boat(passengerCount, engineCapacity, fuelInTank, posX, posY, turbineCount);
    }

    @Override
    public int getTurbineCount() {
        return boat.getTurbineCount();
    }

    @Override
    public void sailTo(Destination destination) throws Exception {
        boat.sailTo(destination);
        this.posX = boat.posX;
        this.posY = boat.posY;
        this.fuelInTank = boat.fuelInTank;
    }

    @Override
    public void driveTo(Destination destination) throws Exception {
        super.driveTo(destination);
        boat.posX = this.posX;
        boat.posY = this.posY;
        boat.fuelInTank = this.fuelInTank;
    }
}
