package pl.edu.pjwstk.s20265.mas.mp5;

import jakarta.persistence.Persistence;
import pl.edu.pjwstk.s20265.mas.mp5.Inheritance.DigitalRecord;
import pl.edu.pjwstk.s20265.mas.mp5.Inheritance.DigitalRecord.DigitalRecordType;
import pl.edu.pjwstk.s20265.mas.mp5.Inheritance.VinylRecord;
import pl.edu.pjwstk.s20265.mas.mp5.OneToMany.Car;
import pl.edu.pjwstk.s20265.mas.mp5.OneToMany.Driver;
import pl.edu.pjwstk.s20265.mas.mp5.SimpleClass.Invoice;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.logging.Level;

public class Main {
    public static void main(String[] args) {
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.WARNING);

        // Simple class
        var invoice1= new Invoice(LocalDateTime.now(), new BigDecimal("999.90"));
        var invoice2 = new Invoice(LocalDateTime.now().minusMonths(1), new BigDecimal("899.90"));

        // One to many
        var car = new Car("Opel", "Astra", Year.of(2000));
        var client = new Driver("John", "Carman");
        car.setDriver(client);

        // Inheritance
        var digitalRecord = new DigitalRecord("Four", "Joris Voorn", DigitalRecordType.CD);
        var vinylRecord = new VinylRecord("Random Friday", "Solar Fields", 33);

        // Persistence
        var entityManagerFactory = Persistence.createEntityManagerFactory("hibernate");
        var entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(invoice1);
        entityManager.persist(invoice2);

        entityManager.persist(client);
        entityManager.persist(car);

        entityManager.persist(digitalRecord);
        entityManager.persist(vinylRecord);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
