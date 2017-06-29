package application.model;

/**
 * Class description ...
 * Included in application.model
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 25. Apr 2017
 */
public enum Gender {
    MALE("male"),
    FEMALE("female"),
    OTHERS("others");

    public final String name;

    Gender(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
