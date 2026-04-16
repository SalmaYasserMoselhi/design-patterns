public class Director extends BorrowHandler {

    @Override
    public void approveBorrow(User user, Book book, int days) {
        System.out.println("Director approved borrowing \"" + book.getTitle()
                + "\" for " + user.getName() + " for " + days + " days.");
    }
}
