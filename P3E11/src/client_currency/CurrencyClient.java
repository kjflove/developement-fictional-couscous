package client_currency;

import communication.CurrencyData;
import communication.SupportedCurrency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class description ...
 * Included in client_currency
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 30. Jun 2017
 */
public class CurrencyClient {

    private static volatile ClientState state = ClientState.NONE;

    public static void main(String[] args) {
        // new QuitListener(state).start();
        Scanner sn = new Scanner(System.in);
        System.out.println("Type `quit` to leave the client at any time!");
        while(!state.equals(ClientState.QUIT)) {
            try (Socket client = new Socket("localhost", 9898);
                 ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
                 BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()))){
                try{
                    System.out.println("Please enter a currency [DM|EUR]: ");
                    SupportedCurrency readInFrom = SupportedCurrency.valueOf(sn.nextLine());
                    System.out.println("Now enter the money you want to exchange: ");
                    double readMoney = sn.nextDouble();
                    sn.nextLine();

                    CurrencyData currencyData = readInFrom.createData(readMoney);
                    out.writeObject(currencyData);
                    System.out.println(in.readLine());
                } catch (InputMismatchException | IllegalArgumentException e){
                    System.out.println("Some inputs were wrong. Make sure to use `,` in decimals.");
                }
            } catch (ConnectException e) {
                System.out.println("Please start the server, before you start the client! No connection established.");
                System.out.println("Please also check your firewall settings.");
                System.exit(1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
