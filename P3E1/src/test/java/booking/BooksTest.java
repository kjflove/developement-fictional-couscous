package booking;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Class description ...
 * Included in booking
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 14. Apr 2017
 */
public class BooksTest {

    Books testingBooks;

    @Before
    public void setUp() throws Exception {
        testingBooks = new Books();
        Book marv = new Book(213, "Marvin", "HauHau", "IBSN-214-214a", Publisher.HANZO, 2017);
        Book jan = new Book(13, "Jan", "Die sieben Tiger", "ISBN-311-918", Publisher.KLETT, 2002);
        testingBooks.addBook(marv);
        testingBooks.addBook(jan);
    }

    @Test
    public void addBook() throws Exception {
        Book test = new Book(22, "Kao", "Romeo and Julia", "ISBN-341-9182", Publisher.PEARSON, 1972);
        testingBooks.addBook(test);
        assertEquals(testingBooks.getByID(22), test);
    }

    @Test
    public void retriveBookInfo() throws Exception {
        boolean ex = false;
        try {
            testingBooks.retriveBookInfo(13);
        } catch (Exception e) {
            ex = true;
        }
        assertEquals(ex, false);
        ex = false;

        try {
            String info = testingBooks.retriveBookInfo(1000);
            assertEquals(info, "ID not available.");
        } catch (Exception e) {
            ex = true;
        }

        assertEquals(ex, false);
    }

    @Test
    public void correctBookData() throws Exception {

    }

    @Test
    public void getByID() throws Exception {
    }
}