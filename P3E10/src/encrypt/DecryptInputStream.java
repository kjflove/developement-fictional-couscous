package encrypt;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Class description ...
 * Included in PACKAGE_NAME
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 28. Jun 2017
 */
public class DecryptInputStream extends FilterInputStream implements Encryptable {

    private KeyStorage key;

    /**
     * Creates a <code>FilterInputStream</code>
     * by assigning the  argument <code>in</code>
     * to the field <code>this.in</code> so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or <code>null</code> if
     *           this instance is to be created without an underlying stream.
     */
    protected DecryptInputStream(InputStream in, KeyStorage key) {
        super(in);
        this.key = key;
    }

    @Override
    public int read(byte[] b) throws IOException {
        int read = super.read(b);
        this.decrypt(key, b);
        return read;
    }
}
