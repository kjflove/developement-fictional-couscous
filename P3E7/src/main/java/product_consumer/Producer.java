package product_consumer;

import java.io.*;
import java.util.stream.IntStream;

/**
 * Class description ...
 * Included in product_consumer
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 02. Jun 2017
 */
public class Producer extends Thread {
    private PipedOutputStream outputStream;
    private DataOutputStream dataOutputStream;
    private PipedInputStream inputStream;
    private DataInputStream dataInputStream;

    private int productionIteration;
    
    private int produceProducts(){
        return (int)((Math.random() * 60) + 1);
    }

    @Override
    public void run() {

        this.dataOutputStream = new DataOutputStream(outputStream);
        this.dataInputStream = new DataInputStream(inputStream);

        IntStream.range(0, productionIteration - 1).forEach(index -> {
            try {
                this.dataOutputStream.writeInt(Communication.PRODUCED_PRODUCT.getNumber());
                int producedProducts = produceProducts();
                Products.insertProduct(producedProducts);
                System.out.println("Produced " + producedProducts + " product(s).");
                System.out.println("waiting for consumer to consume this product.");
                this.dataInputStream.readInt();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        try {
            this.dataOutputStream.writeInt(Communication.STOPPED_PRODCUTION.getNumber());
            System.out.println("Stopped production");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            this.dataOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Producer(int productionIteration, PipedOutputStream outputStream, PipedInputStream inputStream) {
        this.productionIteration = productionIteration;
        this.outputStream = outputStream;
        this.inputStream = inputStream;
    }
}
