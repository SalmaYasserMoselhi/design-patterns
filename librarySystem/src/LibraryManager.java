public class LibraryManager {
    private LibraryService libraryService;
    private BorrowHandler approvalChain;

    public LibraryManager() {
        this.libraryService = LibraryService.getInstance();

        Librarian librarian = new Librarian();
        Manager manager = new Manager();
        Director director = new Director();
        librarian.setNextHandler(manager);
        manager.setNextHandler(director);
        this.approvalChain = librarian;
    }

    public void borrowBook(String title, User user, int days) {
        Book book = libraryService.findBook(title);
        if (book == null) {
            System.out.println("Book \"" + title + "\" not found.");
            return;
        }

        if (!book.isAvailable()) {
            System.out.println("Book \"" + title + "\" is not available.");
            return;
        }

        approvalChain.approveBorrow(user, book, days);
        book.borrowBook(user);
    }
}
