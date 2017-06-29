package booking;

/**
 * Class description ...
 * Included in booking
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 13. Apr 2017
 */
public interface IBook {

    <T> void correctInfo(BookAttribute attr, T info);
    String info();
    boolean checkID(int id);
    int getID();

}
