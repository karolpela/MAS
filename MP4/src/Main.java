import ordered.Book;
import ordered.Bookshelf;
import subset.Businessman;
import subset.Company;
import unique.Player;

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

        //TODO demonstrate bag
    }
}