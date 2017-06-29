package booking;

/**
 * Class description ...
 * Included in booking
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 14. Apr 2017
 */
public class IDNotAvailableException extends Exception {

    public IDNotAvailableException(String error) {
        super(error);
        System.out.println(error);
    }

}
