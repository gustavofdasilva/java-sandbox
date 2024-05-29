import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<Book>();
        System.out.println("Welcome to master library!");
        Boolean replay = true;

        Date d = new Date();

        while(replay) {
            System.out.println(" ");
            System.out.println("See all books: 'B' | Add new book: 'N' | Remove book: 'R' | Exit: 'E'");
            switch (sc.nextLine()) {
                case "B":
                    System.out.println(" ");
                    System.out.println("Books that are in the Library:");

                    for(Book book : books) {
                        System.out.printf("%s - %s (added in %s)",book.getName(), book.getDateLaunched(), book.getDateAdded().toString());
                        System.out.println(" ");
                    }
                    break;
                case "N":
                    System.out.println(" ");
                    System.out.println("Name of the book?");
                    String name = sc.nextLine();
    
                    System.out.println(" ");
                    System.out.println("Year of launch?");
                    String dateLaunched = sc.nextLine();
    
                    Book book = new Book(name, Instant.now() , dateLaunched);
                    books.add(book);
                    break;
                case "R":
                    System.out.println(" ");
                    System.out.println("Name of the book to remove?");
                    name = sc.nextLine();
                    Book toDelete = new Book();
    
                    for(Book each : books) {
                        if(each.getName().equals(name)) {
                            toDelete = each;
                        }
                    }

                    books.remove(toDelete);
                    break;
                
                case "E":
                    replay = false;

                    break;
                default:
                    break;
            }
        }
        
    }


}
