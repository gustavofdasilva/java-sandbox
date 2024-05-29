import java.time.Instant;

public class Book {
    private String name;
    private Instant dateAdded;
    private String dateLaunched;
    
    public Book(String name, Instant dateAdded, String dateLaunched) {
        this.name = name;
        this.dateAdded = dateAdded;
        this.dateLaunched = dateLaunched;
    }

    public Book() {
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instant getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Instant dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getDateLaunched() {
        return dateLaunched;
    }

    public void setDateLaunched(String dateLaunched) {
        this.dateLaunched = dateLaunched;
    }
}
