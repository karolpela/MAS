package pl.edu.pjwstk.s20265.mas.mp5.OneToMany;

import jakarta.persistence.*;

import java.time.Year;

@Entity
public class Car {
    @Id
    @GeneratedValue
    private Long id;

    private String make;
    private String model;
    private Year manufactureYear;

    @ManyToOne()
    private Driver driver;

    // Required by Hibernate
    public Car() {
    }

    public Car(String make, String model, Year manufactureYear) {
        this.make = make;
        this.model = model;
        this.manufactureYear = manufactureYear;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Year getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(Year manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
        if (driver == null) {
            return;
        }
        if (!driver.cars.contains(this)) {
            driver.addCar(this);
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", manufactureYear=" + manufactureYear +
                ", driver=" + driver +
                '}';
    }
}
