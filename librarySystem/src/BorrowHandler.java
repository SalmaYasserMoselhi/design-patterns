public abstract class BorrowHandler {
    protected BorrowHandler nextHandler;

    public void setNextHandler(BorrowHandler next) {
        this.nextHandler = next;
    }

    public abstract void approveBorrow(User user, Book book, int days);
}
