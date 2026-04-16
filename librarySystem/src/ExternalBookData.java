public class ExternalBookData {
    private String bookTitle;
    private boolean isBorrowable;
    private String authorName;
    private int year;

    public ExternalBookData(String bookTitle, boolean isBorrowable, String authorName, int year) {
        this.bookTitle = bookTitle;
        this.isBorrowable = isBorrowable;
        this.authorName = authorName;
        this.year = year;
    }

    public String getBookTitle() { return bookTitle; }
    public boolean isBorrowable() { return isBorrowable; }
    public String getAuthorName() { return authorName; }
    public int getYear() { return year; }
}
