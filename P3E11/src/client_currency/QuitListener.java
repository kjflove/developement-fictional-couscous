package client_currency;

import javafx.beans.property.Property;
import server_currency.ServerState;

import java.util.Scanner;

/**
 * Class description ...
 * Included in client_currency
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 30. Jun 2017
 */
public class QuitListener extends Thread {

    private Scanner sn;
    private volatile ClientState state;

    /**
     * Allocates a new {@code Thread} object. This constructor has the same
     * {@code (null, null, gname)}, where {@code gname} is a newly generated
     * name. Automatically generated names are of the form
     * {@code "Thread-"+}<i>n</i>, where <i>n</i> is an integer.
     * @param state
     */
    public QuitListener(ClientState state) {
        this.sn = new Scanner(System.in);
        this.state = state;
    }

    /**
     * If this thread was constructed using a separate
     * <code>Runnable</code> run object, then that
     * <code>Runnable</code> object's <code>run</code> method is called;
     * otherwise, this method does nothing and returns.
     * <p>
     * Subclasses of <code>Thread</code> should override this method.
     *
     * @see #start()
     * @see #stop()
     */
    @Override
    public void run() {
        while(!this.state.equals(ClientState.QUIT)) {
            String input = sn.nextLine();
            if (input.toLowerCase().equals("quit")) {
                this.state = ClientState.QUIT;
            }
        }
    }
}
