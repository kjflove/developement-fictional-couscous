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
 * @since 18. Apr 2017
 */
public class PrintMenu extends BasePlugin {

    public PrintMenu(String name) {
        super(name);
    }

    /**
     * Executes the certain plugin
     *
     * @param list stack which will be used for that.
     * @param sn
     */
    @Override
    public void executePlugin(Books<Book> list, Scanner sn) throws Exception {
        int size = list.length();
        if(size <= 0){
            System.out.println("You can't print anything. Your library is empty.");
        } else {
            System.out.printf("Please enter your Book ID you want to look up: ");
            int id = sn.nextInt();
            System.out.println(list.retriveBookInfo(id));
        }
    }
}
