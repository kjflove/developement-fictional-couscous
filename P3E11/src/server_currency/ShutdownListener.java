package server_currency;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Class description ...
 * Included in server_currency
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 30. Jun 2017
 */
public class ShutdownListener extends Thread {

    private Scanner sn;
    private volatile Property<ServerState> state;
    private ServerSocket listener;
    /**
     * Allocates a new {@code Thread} object. This constructor has the same
     * {@code (null, null, gname)}, where {@code gname} is a newly generated
     * name. Automatically generated names are of the form
     * {@code "Thread-"+}<i>n</i>, where <i>n</i> is an integer.
     */
    public ShutdownListener(Property<ServerState> state, ServerSocket listener) {
        this.sn = new Scanner(System.in);
        this.state = state;
        this.listener = listener;
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
        while(!this.state.getValue().equals(ServerState.SHUTDOWN)) {
            String input = sn.nextLine();
            if (ServerState.SHUTDOWN.name().toLowerCase().equals(input.toLowerCase())) {
                this.state.setValue(ServerState.SHUTDOWN);
                try {
                    this.listener.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
