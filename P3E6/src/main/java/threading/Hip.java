package threading;

import java.io.DataOutputStream;
import java.io.IOException;
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
public class Hip extends Thread {
    private final String text = "HIP";
    private PipedOutputStream output;
    private DataOutputStream writer;

    public Hip(PipedOutputStream output){
        this.output = output;
        writer = new DataOutputStream(output);
    }

    @Override
    public void run() {
        while (true) {
            try{
                double math = Math.random() * 3;
                writer.writeInt((int)math);
                IntStream.range(0, (int)(Math.random() * 3)).forEach(number -> {
                        System.out.println("[ T1 | " + this.getPriority() + " ] " + text);
                });
                sleep(1000);
            }catch (IOException | InterruptedException e){
                e.printStackTrace();
            }

        }

    }
}
