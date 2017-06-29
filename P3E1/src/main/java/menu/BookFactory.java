package menu;

import booking.Book;
import booking.Books;
import booking.Publisher;

import java.util.Calendar;
import java.util.Scanner;

/**
 * Class description ...
 * Included in menu
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 14. Jan 2017
 */
public class BookFactory {

    public static Book createNewBook(Books<Book> list, Scanner sn) throws Exception{

        System.out.println("Creating a new Book ...");
        System.out.printf("Identification:");
        int ID = sn.nextInt();

        if (list.isIdReserved(ID)) throw new Exception("Ups ID is already in use.");

        sn.nextLine();

        System.out.printf("Author:");
        String author = sn.nextLine();

        System.out.printf("ISBN:");
        String ISBN = sn.next();

        sn.nextLine();

        System.out.printf("Title:");
        String title = sn.nextLine();

        System.out.println("Publisher");
        for (Publisher publisher : Publisher.values()) {
            System.out.println(publisher.ordinal() + " - " + publisher.name());
        }

        System.out.printf("choosen publisher:");
        int pub = sn.nextInt();
        Publisher publisher = Publisher.values()[pub];

        System.out.printf("release year:");
        int releaseYear = sn.nextInt();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        if(releaseYear < 0 || releaseYear > currentYear)
            throw new Exception("Ups year isn't valid");


        return new Book(ID, author, title, ISBN, publisher, releaseYear);
    }

}
