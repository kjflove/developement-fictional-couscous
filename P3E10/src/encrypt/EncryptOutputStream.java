package encrypt;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Class description ...
 * Included in PACKAGE_NAME
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 28. Jun 2017
 */
public class EncryptOutputStream extends FilterOutputStream implements Encryptable {

    private KeyStorage key;

    /**
     * Creates an output stream filter built on top of the specified
     * underlying output stream.
     *
     * @param out the underlying output stream to be assigned to
     *            the field <tt>this.out</tt> for later use, or
     *            <code>null</code> if this instance is to be
     *            created without an underlying stream.
     */
    public EncryptOutputStream(OutputStream out, KeyStorage key) {
        super(out);
        this.key = key;
    }

    @Override
    public void write(byte[] b) throws IOException {
        byte[] out = this.encrypt(key, b);
        super.write(out);
    }
}
