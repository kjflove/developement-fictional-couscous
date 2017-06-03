package product_consumer;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

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
public class Consumer extends Thread {
    private PipedInputStream inputStream;
    private PipedOutputStream outputStream;
    private DataOutputStream dataOutputStream;
    private DataInputStream dataInputStream;

    @Override
    public void run() {
        this.dataInputStream = new DataInputStream(inputStream);
        while(true){
            try {
                int communication = this.dataInputStream.readInt();
                if(communication == Communication.PRODUCED_PRODUCT.getNumber()){
                    Integer product = Products.removeProduct();
                    System.out.println("Yeah, we got " + product + " product(s).");
                    this.dataOutputStream = new DataOutputStream(outputStream);
                    this.dataOutputStream.writeInt(Communication.FINISHED_CONSUMING.getNumber());
                } else if(communication == Communication.STOPPED_PRODCUTION.getNumber()){
                    System.out.println("Production closed, Consumer stopped waiting.");
                    this.dataOutputStream.close();
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                System.out.println("Oh you shouldn't have accessed the product container.");
            }
        }

        try {
            this.dataInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Consumer(PipedInputStream inputStream, PipedOutputStream outputStream) {
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }
}
