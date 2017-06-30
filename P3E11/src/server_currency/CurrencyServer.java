package server_currency;

import com.sun.corba.se.spi.activation.Server;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;

import java.net.ServerSocket;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Class description ...
 * Included in server_currency
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 29. Jun 2017
 */
public class CurrencyServer {

    private static volatile Property<ServerState> state = new SimpleObjectProperty<>();

    public static void main(String[] args) throws Exception {
        state.addListener((observable, oldValue, newValue) -> newValue.log());
        state.setValue(ServerState.STARTING);
        ExecutorService executor = Executors.newFixedThreadPool(5);

        try(ServerSocket listener = new ServerSocket(9898)) {
            new ShutdownListener(state, listener).start();
            while (!state.equals(ServerState.SHUTDOWN)) {
                state.setValue(ServerState.READY);
                ExchangeCalculator clientConnection = new ExchangeCalculator(listener.accept(), state);
                executor.execute(clientConnection);
            }
        } catch (SocketException e) {
            System.out.println("Server socket has been closed remotely, Server will shutdown now!");
        }
    }
}
