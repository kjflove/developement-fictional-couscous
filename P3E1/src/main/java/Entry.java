import menu.MenuManager;
import menu.MenuPlugins;
import menu.plugin.AddMenu;
import menu.plugin.ExitMenu;
import menu.plugin.ListAllMenu;
import menu.plugin.PrintMenu;


/**
 * Class description ...
 * Included in PACKAGE_NAME
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 13. Apr 2017
 */
public class Entry {
    public static void main(String[] args) {

        MenuPlugins mps = new MenuPlugins(
                new AddMenu("add a new book"),
                new PrintMenu("print book details"),
                new ListAllMenu("list all book ID"),
                new ExitMenu("exit program")
        );

        new MenuManager(mps).initialze();

    }

}
