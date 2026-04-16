public class Main {
    public static void main(String[] args) {
        LibraryService library = LibraryService.getInstance();

        library.addBook(BookFactory.createBook("physical", "Harry Potter"));
        library.addBook(BookFactory.createBook("ebook", "Digital World"));
        library.addBook(BookFactory.createBook("historical", "Ancient Egypt"));

        Book premiumBook = new PremiumBook(BookFactory.createBook("physical", "Clean Code"));
        library.addBook(premiumBook);
        System.out.println("Default borrowing days: " + BookFactory.createBook("physical", "Test").getBorrowingDays());
        System.out.println("Premium borrowing days: " + premiumBook.getBorrowingDays());

        Book secureEbook = new SecureEBook(new EBook("AI Fundamentals"));
        library.addBook(secureEbook);

        User salma = new User("Salma", true);
        User ahmad = new User("Ahmad", false);
        User rana = new User("Rana", true);

        secureEbook.borrowBook(salma);
        secureEbook.borrowBook(ahmad);

        BorrowHandler librarian = new Librarian();
        BorrowHandler manager = new Manager();
        BorrowHandler director = new Director();
        librarian.setNextHandler(manager);
        manager.setNextHandler(director);

        Book hp = library.findBook("Harry Potter");
        librarian.approveBorrow(salma, hp, 5);
        librarian.approveBorrow(rana, hp, 10);
        librarian.approveBorrow(ahmad, hp, 20);

        LibraryManager libManager = new LibraryManager();
        libManager.borrowBook("Ancient Egypt", salma, 5);

        ExternalBookData externalData = new ExternalBookData("Design Patterns", true, "Erich Gamma", 1994);
        Book importedBook = new ImportedBook(externalData);
        library.addBook(importedBook);
        System.out.println("Imported book: " + importedBook.getTitle());
        System.out.println("Author: " + ((ImportedBook) importedBook).getAuthor());
        System.out.println("Year: " + ((ImportedBook) importedBook).getYear());

        library.addToWaitingList("Harry Potter", salma);
        library.addToWaitingList("Harry Potter", rana);
        library.returnBook("Harry Potter");
    }
}
