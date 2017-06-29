package menu.plugin;

import booking.Book;
import booking.Books;
import menu.BookFactory;

import java.util.Scanner;

/**
 * Class description ...
 * Included in menu.plugin
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 14. Jan 2017
 */
public class AddMenu extends BasePlugin {

    public AddMenu(String MENU_NAME) {
        super(MENU_NAME);
    }

    /**
     * Executes the certain plugin
     *
     * @param list stack which will be used for that.
     */
    public void executePlugin(Books<Book> list, Scanner sn) throws Exception {
        list.addBook(BookFactory.createNewBook(list, sn));
    }
}
