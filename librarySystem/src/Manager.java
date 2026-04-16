public class Manager extends BorrowHandler {

    @Override
    public void approveBorrow(User user, Book book, int days) {
        if (days <= 14) {
            System.out.println("Manager approved borrowing \"" + book.getTitle()
                    + "\" for " + user.getName() + " for " + days + " days.");
        } else if (nextHandler != null) {
            nextHandler.approveBorrow(user, book, days);
        } else {
            System.out.println("No one can approve borrowing for " + days + " days.");
        }
    }
}
