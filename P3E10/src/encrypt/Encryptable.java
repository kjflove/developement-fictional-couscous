package encrypt;

/**
 * Class description ...
 * Included in PACKAGE_NAME
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 28. Jun 2017
 */
public interface Encryptable {
    default byte[] encrypt(KeyStorage key, byte[] outBytes){
        byte[] encryptedBytes = new byte[outBytes.length];
        for (int i = 0; i < outBytes.length; i++) {
            encryptedBytes[i] = (byte) (outBytes[i] ^ key.getKey()[i % key.getKey().length]);
        }
        return encryptedBytes;
    }

    default void decrypt(KeyStorage key, byte[] inBytes){
        for (int i = 0; i < inBytes.length; i++) {
            inBytes[i] = (byte) (inBytes[i] ^ key.getKey()[i % key.getKey().length]);
        }
    }
}
