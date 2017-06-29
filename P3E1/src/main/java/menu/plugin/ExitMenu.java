package menu.plugin;

import booking.Book;
import booking.Books;

import java.util.Scanner;

/**
 * Class description ...
 * Included in menu.plugin
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 14. Jan 2017
 */
public class ExitMenu extends BasePlugin {

    public ExitMenu(String MENU_NAME) {
        super(MENU_NAME);
    }

    /**
     * Executes the certain plugin
     *
     * @param list stack which will be used for that.
     * @param sn
     */
    @Override
    public void executePlugin(Books<Book> list, Scanner sn) throws Exception {
        System.exit(0);
    }

}
