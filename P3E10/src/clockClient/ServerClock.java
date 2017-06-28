package clockClient;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * Class description ...
 * Included in clockClient
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 28. Jun 2017
 */
public class ServerClock {
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(18000)) {
            while(true) {
                Socket socket = serverSocket.accept();
                PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                pw.println("The current time is: " + sdf.format(new Date()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
