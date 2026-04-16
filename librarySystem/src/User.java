public class User implements BookAvailabilityListener {
    private String name;
    private boolean isPremium;

    public User(String name) {
        this.name = name;
    }

    public User(String name, boolean isPremium) {
        this.isPremium = isPremium;
        this.name = name;
    }

    public String getName() { return name; }
    public boolean isPremium() { return isPremium; }
    public void setName(String name) { this.name = name; }
    public void setPremium(boolean premium) { isPremium = premium; }

    @Override
    public void onBookAvailable(String bookTitle) {
        System.out.println(name + " has been notified: " + bookTitle + " is now available!");
    }
}
