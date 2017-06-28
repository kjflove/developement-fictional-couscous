package clockClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Class description ...
 * Included in clockClient
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 28. Jun 2017
 */
public class ClientClock {
    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost", 18000);
            BufferedReader readIn = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String line = readIn.readLine();
            System.out.println(line);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
