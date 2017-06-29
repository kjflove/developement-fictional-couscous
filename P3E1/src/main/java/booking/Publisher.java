package booking;

/**
 * Class description ...
 * Included in booking
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 13. Apr 2017
 */
public enum Publisher {
    KLETT("Klett"),
    VERLAG("Verlag name 33"),
    PEARSON("Pearson"),
    SPECTOR("Spector"),
    HANZO("Hanzo");

    private final String name;

    Publisher(String name){
        this.name = name;
    }

    public String getPublisherName(){
        return this.name;
    }
}
