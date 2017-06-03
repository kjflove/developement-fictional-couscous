package threading;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Class description ...
 * Included in threading
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 31. Mai 2017
 */
public class HipHopThread {

    private PipedInputStream inputStream;
    private PipedOutputStream outputStream;

    public HipHopThread() throws Exception{
        inputStream = new PipedInputStream();
        outputStream = new PipedOutputStream(inputStream);

        Hip hip = new Hip(outputStream);
        Hop hop = new Hop(inputStream);
        //hip.setDaemon(true);
        hip.start();
        //hop.setDaemon(true);
        hop.start();
    }

    public static void main(String[] args) throws Exception {
        HipHopThread hh = new HipHopThread();
    }
}
