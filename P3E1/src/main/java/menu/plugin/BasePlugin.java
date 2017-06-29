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
public abstract class BasePlugin {

    public final String name;

    public BasePlugin(String name) {
        this.name = name;
    }

    /**
     * Executes the certain plugin
     *
     * @param list stack which will be used for that.
     */
    public abstract void executePlugin(Books<Book> list, Scanner sn) throws Exception;

}
