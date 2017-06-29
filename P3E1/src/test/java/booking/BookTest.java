package booking;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Class description ...
 * Included in booking
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 19. Apr 2017
 */
public class BookTest {

    Book book = new Book(2131, "Marvin Piekarek", "The holy Moly", "42153151", Publisher.PEARSON, 2002);

    @Test
    public void stringTest() throws Exception {
        boolean exc = false;
        try{
            book.toString();
        } catch(Exception e) {
            exc = true;
        }

        assertFalse(exc);
    }

    @Test
    public void correctInfo() throws Exception {

        // ID
        book.correctInfo(BookAttribute.ID, 213);
        assertEquals(book.getID(), 213);
        book.correctInfo(BookAttribute.ID, "sad");
        assertEquals(book.getID(), 213);

        // AUTHOR
        book.correctInfo(BookAttribute.AUTHOR, "KYON");
        assertEquals(book.getAuthor(), "KYON");
        book.correctInfo(BookAttribute.AUTHOR, 22);
        assertEquals(book.getAuthor(), "KYON");

        // TITLE
        book.correctInfo(BookAttribute.TITLE, "AYEddd     ");
        assertEquals(book.getTitle(), "AYEddd     ");
        book.correctInfo(BookAttribute.TITLE, Publisher.HANZO);
        assertEquals(book.getTitle(), "AYEddd     ");

        // ISBN
        book.correctInfo(BookAttribute.ISBN, "214141");
        assertEquals(book.getISBN(), "214141");
        book.correctInfo(BookAttribute.ISBN, Publisher.HANZO);
        assertEquals(book.getISBN(), "214141");

        // PUBLISHER
        book.correctInfo(BookAttribute.PUBLISHER, Publisher.SPECTOR);
        assertEquals(book.getPublisher(), Publisher.SPECTOR);
        book.correctInfo(BookAttribute.PUBLISHER, "ABC");
        assertEquals(book.getPublisher(), Publisher.SPECTOR);

        // RELEASE_YEAR
        book.correctInfo(BookAttribute.RELEASE_YEAR, 1999);
        assertEquals(book.getReleaseYear(), 1999);
        book.correctInfo(BookAttribute.RELEASE_YEAR, "dawsa");
        assertEquals(book.getReleaseYear(), 1999);

    }

    @Test
    public void checkID() throws Exception {
        assertTrue(book.checkID(2131));
        assertFalse(book.checkID(222));
    }

}