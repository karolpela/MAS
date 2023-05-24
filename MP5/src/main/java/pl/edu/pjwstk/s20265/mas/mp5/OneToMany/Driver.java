package pl.edu.pjwstk.s20265.mas.mp5.OneToMany;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Driver {

    @OneToMany(mappedBy = "driver")
    final Set<Car> cars = new HashSet<>();

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;

    public Driver() {

    }

    public Driver(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addCar(Car car) {
        if (this.cars.add(car)) {
            car.setDriver(this);
        }
    }

    public void removeCar(Car car) {
        if (this.cars.remove(car)) {
            car.setDriver(null);
        }
    }

    public Set<Car> getCars() {
        return cars;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
