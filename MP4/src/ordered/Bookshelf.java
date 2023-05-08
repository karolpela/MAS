package ordered;

import java.util.ArrayList;
import java.util.List;

public class Bookshelf {
    private final List<Book> books = new ArrayList<>();

    public boolean addBook(Book book) {
        if (!this.books.contains(book)) {
            return books.add(book);
        } else {
            return false;
        }
    }

    public Iterable<Book> getBooks() {
        return books;
    }
}
