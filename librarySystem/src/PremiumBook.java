public class PremiumBook extends BookWrapper {

    public PremiumBook(Book book) {
        super(book);
    }

    @Override
    public int getBorrowingDays() {
        return super.getBorrowingDays() + 10;
    }
}
