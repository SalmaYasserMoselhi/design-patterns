public class SecureEBook extends Book {
    private EBook realEBook;

    public SecureEBook(EBook ebook) {
        super(ebook.getTitle());
        this.realEBook = ebook;
    }

    @Override
    public void borrowBook(User user) {
        if (!user.isPremium()) {
            System.out.println("Access denied. Premium only.");
        } else {
            realEBook.borrowBook(user);
        }
    }

    @Override
    public void returnBook() {
        realEBook.returnBook();
    }
}
