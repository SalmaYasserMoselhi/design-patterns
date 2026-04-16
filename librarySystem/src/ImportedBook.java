public class ImportedBook extends Book {
    private ExternalBookData externalData;

    public ImportedBook(ExternalBookData data) {
        super(data.getBookTitle());
        this.externalData = data;
    }

    @Override
    public boolean isAvailable() {
        return externalData.isBorrowable();
    }

    public String getAuthor() {
        return externalData.getAuthorName();
    }

    public int getYear() {
        return externalData.getYear();
    }
}
