package product_consumer;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.LinkedList;
import java.util.List;

/**
 * Class description ...
 * Included in product_consumer
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 02. Jun 2017
 */
public class Production {

    public static List<Thread> threads = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        PipedOutputStream outP = new PipedOutputStream();
        PipedOutputStream outC = new PipedOutputStream();
        PipedInputStream inC = new PipedInputStream(outP);
        PipedInputStream inP = new PipedInputStream(outC);



        Producer p = new Producer(50, outP, inP);
        Consumer c = new Consumer(inC, outC);
        threads.add(p);
        threads.add(c);
        p.start();
        c.start();

        threads.forEach(e -> {
            try {
                e.join();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        });
    }


}
