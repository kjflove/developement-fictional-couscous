package encrypt;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Class description ...
 * Included in PACKAGE_NAME
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 28. Jun 2017
 */
public class KeyStorage {

    private byte[] key;

    public KeyStorage(int seed){
        Random rnd = new Random(seed);
        int max = rnd.nextInt(1024);
        key = new byte[max];
        rnd.nextBytes(key);
    }

    public byte[] getKey() {
        return key;
    }
}
