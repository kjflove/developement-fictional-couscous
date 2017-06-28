package encrypt;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.Scanner;

/**
 * Class description ...
 * Included in PACKAGE_NAME
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 28. Jun 2017
 */
public class Entry {

    private static final String ENCRYPTED_FILE = "/Users/marvinpiekarek/Desktop/development/Pr0gramming/P3E10/src/encrypt/EncryptKappa.txt";

    public static void main(String[] args) {
        KeyStorage key = new KeyStorage(new Random().nextInt());
        Scanner sc = new Scanner(System.in);
        String toWrite = sc.nextLine();
        byte[] readIn = new byte[toWrite.getBytes().length];

        try(InputStream inputStream = new FileInputStream(ENCRYPTED_FILE);
            OutputStream outputStream = new FileOutputStream(ENCRYPTED_FILE)){

            EncryptOutputStream output = new EncryptOutputStream(outputStream, key);
            output.write(toWrite.getBytes());

            DecryptInputStream input = new DecryptInputStream(inputStream, key);
            //noinspection ResultOfMethodCallIgnored
            input.read(readIn);
            System.out.println(new String(readIn, StandardCharsets.UTF_8));

        } catch (FileNotFoundException e){
            System.out.println("File not found ...");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
