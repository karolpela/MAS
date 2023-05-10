import attribute.AirConditioner;
import bag.Olympics;
import bag.Performance;
import bag.Sportsperson;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.ArrayList;
import ordered.Book;
import ordered.Bookshelf;
import own.Planner;
import subset.Businessman;
import subset.Company;
import unique.Player;
import xor.Citizen;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n>> {unique} - Create players");
        try {
            var player1 = new Player("MASter of Java");
            System.out.println("Created player: " + player1);
            var player2 = new Player("ThoMAS the Great");
            System.out.println("Created player: " + player2);
            var player3 = new Player("MASter of Java");
            System.out.println("Created player: " + player3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n>> {subset} - Companies and stakeholders");
        var company = new Company("MAS Industries");
        var businessman = new Businessman("Smith");
        businessman.makeChairperson(company);
        businessman.makeStakeholder(company);
        businessman.makeChairperson(company);
        System.out.println(
                "Company - stakeholders: " + company.getStakeholders()
                        + ", chairpersons: " + company.getChairpersons());
        System.out.println("> Unmake the businessman a stakeholder");
        businessman.unmakeStakeholder(company);
        System.out.println(
                "Company - stakeholders: " + company.getStakeholders()
                        + ", chairpersons: " + company.getChairpersons());

        System.out.println("\n>> {ordered} - Books on a bookshelf");
        var bookshelf = new Bookshelf();
        var book1 = new Book("Historia filozofii. Tom 1. Filozofia starożytna i średniowieczna");
        var book2 = new Book("Historia filozofii. Tom 2. Filozofia nowożytna do roku 1830");
        var book3 = new Book("Historia filozofii. Tom 3. Filozofia XIX wieku i współczesna");
        bookshelf.addBook(book3);
        bookshelf.addBook(book2);
        bookshelf.addBook(book1);
        System.out.println("Books on the bookshelf: ");
        bookshelf.getBooks().forEach(System.out::println);

        System.out.println("\n>> {bag} - Sportspeople and olympics");
        var sportsperson = new Sportsperson("John Johnson");
        var olympics = new Olympics("London", Year.of(2000));
        olympics.addPerformance(sportsperson, 1, "Rowing");
        sportsperson.addPerformance(olympics, 2, "Sprinting");
        System.out.println(olympics + " - performances:");
        olympics.getPerformances().forEach(System.out::println);
        System.out.println("> Remove the performances");
        var performances = new ArrayList<Performance>();
        olympics.getPerformances().forEach(performances::add);
        performances.forEach(sportsperson::removePerformance);
        System.out.println(sportsperson + " - performances:");
        sportsperson.getPerformances().forEach(System.out::println);

        System.out.println("\n>> Attribute - Air conditioner and temperature");
        try {
            System.out.println("> Try to create AC set to 16 degrees");
            var ac = new AirConditioner(16);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("> Try to create AC set to 19.5 degrees");
            var ac = new AirConditioner(19.5);
            System.out.println(ac);
            System.out.println("> Try to set the AC to 20.5 degrees");
            ac.setTemperature(20.5);
            System.out.println(ac);
            System.out.println("> Try to set the AC to 24.5 degrees");
            ac.setTemperature(24.5);
            System.out.println("> Try to set the AC to 22 degrees");
            ac.setTemperature(22);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n>> Own - Planner and events");
        var calendar = new Planner();
        try {
            System.out.println("> Add an exam");
            calendar.addEvent("MAS exam",
                    LocalDateTime.of(2023, 7, 4, 14, 0),
                    LocalDateTime.of(2023, 7, 4, 15, 30));
            System.out.println("Calendar - events:");
            calendar.getEvents().forEach(System.out::println);
            System.out.println("> Try to add an overlapping exam");
            calendar.addEvent("SAM exam",
                    LocalDateTime.of(2023, 7, 4, 14, 30),
                    LocalDateTime.of(2023, 7, 4, 16, 0));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n>> {XOR} - Citizens, immunities and sentences");
        System.out.println("> Create a new citizen");
        var citizen = new Citizen("Jackson");
        System.out.println(citizen);
        System.out.println("> Give the citizen diplomatic immunity");
        citizen.addImmunity("Diplomatic");
        System.out.println(citizen);
        System.out.println("> Try to give the citizen a sentence");
        citizen.addSentence(LocalDateTime.now(), LocalDateTime.now().plusYears(2), "Corruption");
        System.out.println(citizen);
        System.out.println("> Take away their immunity");
        citizen.removeImmunity();
        System.out.println(citizen);
        System.out.println("> Try to give them a sentence again");
        citizen.addSentence(LocalDateTime.now(), LocalDateTime.now().plusYears(2), "Corruption");
        System.out.println(citizen);
        System.out.println("> Try to give them immunity back");
        citizen.addImmunity("Diplomatic");
        System.out.println(citizen);
    }
}