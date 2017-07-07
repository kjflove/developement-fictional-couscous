package server_currency;

import communication.CurrencyData;
import javafx.beans.property.Property;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.DecimalFormat;

/**
 * Class description ...
 * Included in server_currency
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 29. Jun 2017
 */
public class ExchangeCalculator extends Thread {

    private Socket socket;
    private volatile Property<ServerState> state;
    private CurrencyData request;

    public ExchangeCalculator(Socket socket, Property<ServerState> state){
        this.socket = socket;
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
        this.state.setValue(ServerState.CLIENT_CONNECTED);
        this.state.setValue(ServerState.CLEAN);
        try (ObjectInputStream networkRequest = new ObjectInputStream(socket.getInputStream());
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
            // try to parse out 1. the currency which should be translated.
            this.request = (CurrencyData) networkRequest.readObject();
            // 2. get the information about the exchange value and return
            double exchanged_money = this.request.getFromCurrency().exchange(this.request.getMoneyToExchange());
            DecimalFormat df = new DecimalFormat("###.##");
            out.println("Your exchange has been calculated: " + df.format(exchanged_money) + " " + this.request.getToCurrency().getName());
        } catch (EOFException e) {
            System.out.println("Client closed connection unexpectedly!!");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
