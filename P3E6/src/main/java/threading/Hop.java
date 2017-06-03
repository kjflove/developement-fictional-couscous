package threading;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.stream.IntStream;

/**
 * Class description ...
 * Included in threading
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 31. Mai 2017
 */
public class Hop extends Thread {
    private final String text = "HOP";
    private PipedInputStream input;
    private DataInputStream in;

    public Hop(PipedInputStream input){
        this.input = input;
        this.in = new DataInputStream(input);
    }

    @Override
    public void run() {
        while(true){
            try {
                int i = in.readInt();
                IntStream k = IntStream.range(0, i);
                k.forEach(number -> {
                        System.out.println("[ T2 | " + this.getPriority() + " ] " + text);
                });
                sleep(1000);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
