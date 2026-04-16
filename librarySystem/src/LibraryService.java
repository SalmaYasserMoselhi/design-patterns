import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryService {
    private static LibraryService instance;
    private List<Book> books = new ArrayList<>();
    private Map<String, List<BookAvailabilityListener>> waitingList = new HashMap<>();

    private LibraryService() {}

    public static LibraryService getInstance() {
        if (instance == null) {
            instance = new LibraryService();
        }
        return instance;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public void borrowBook(String title, User user) {
        Book book = findBook(title);
        if (book != null) {
            book.borrowBook(user);
        } else {
            System.out.println("Book not found.");
        }
    }

    public void returnBook(String title) {
        Book book = findBook(title);
        if (book != null) {
            book.returnBook();
            notifyListeners(title);
        } else {
            System.out.println("Book not found.");
        }
    }

    public void addToWaitingList(String title, BookAvailabilityListener listener) {
        waitingList.computeIfAbsent(title, k -> new ArrayList<>()).add(listener);
    }

    private void notifyListeners(String title) {
        List<BookAvailabilityListener> listeners = waitingList.get(title);
        if (listeners != null) {
            for (BookAvailabilityListener listener : listeners) {
                listener.onBookAvailable(title);
            }
            listeners.clear();
        }
    }
}
