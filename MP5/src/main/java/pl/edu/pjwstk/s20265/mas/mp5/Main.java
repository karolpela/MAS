package pl.edu.pjwstk.s20265.mas.mp5;

import jakarta.persistence.Persistence;
import pl.edu.pjwstk.s20265.mas.mp5.Inheritance.DigitalRecord;
import pl.edu.pjwstk.s20265.mas.mp5.Inheritance.DigitalRecord.DigitalRecordType;
import pl.edu.pjwstk.s20265.mas.mp5.Inheritance.Record;
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
        var invoice1 = new Invoice(LocalDateTime.now(), new BigDecimal("999.90"));
        var invoice2 = new Invoice(LocalDateTime.now().minusMonths(1), new BigDecimal("899.90"));
        System.out.println(invoice1);
        System.out.println(invoice2);

        // One to many
        var car1 = new Car("Opel", "Astra", Year.of(2000));
        var car2 = new Car("Toyota", "Prius", Year.of(2004));

        var driver = new Driver("John", "Carman");
        car1.setDriver(driver);
        car2.setDriver(driver);
        System.out.println(driver);
        driver.getCars().forEach(System.out::println);

        // Inheritance
        var digitalRecord = new DigitalRecord("Four", "Joris Voorn", DigitalRecordType.CD);
        var vinylRecord = new VinylRecord("Random Friday", "Solar Fields", 33);
        System.out.println(digitalRecord);
        System.out.println(vinylRecord);
        System.out.println();

        // Persistence
        var entityManagerFactory = Persistence.createEntityManagerFactory("hibernate");
        var session = entityManagerFactory.createEntityManager();

        session.getTransaction().begin();

        session.persist(invoice1);
        session.persist(invoice2);

        session.persist(driver);
        session.persist(car1);

        session.persist(digitalRecord);
        session.persist(vinylRecord);
        session.getTransaction().commit();

        System.out.println("\n");

        var invoicesFromDb = session.createQuery("select i from Invoice i", Invoice.class).getResultList();
        invoicesFromDb.forEach(System.out::println);

        var driverFromDb = session.createQuery("select d from Driver d", Driver.class).getSingleResult();
        System.out.println(driverFromDb);
        driverFromDb.getCars().forEach(System.out::println);

        var recordsFromDb = session.createQuery("select r FROM Record r", Record.class).getResultList();
        recordsFromDb.forEach(System.out::println);

        session.close();
        entityManagerFactory.close();
    }
}
