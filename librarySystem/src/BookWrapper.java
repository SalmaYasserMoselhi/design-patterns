public class BookWrapper extends Book {
    protected Book wrappedBook;

    public BookWrapper(Book book) {
        super(book.getTitle());
        this.wrappedBook = book;
    }

    @Override
    public void borrowBook(User user) {
        wrappedBook.borrowBook(user);
    }

    @Override
    public void returnBook() {
        wrappedBook.returnBook();
    }

    @Override
    public boolean isAvailable() {
        return wrappedBook.isAvailable();
    }

    @Override
    public int getBorrowingDays() {
        return wrappedBook.getBorrowingDays();
    }
}
