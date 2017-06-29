package application.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Class description ...
 * Included in PACKAGE_NAME
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 19. Apr 2017
 */
public enum FieldOfStudies {
    AI (1, "Angewandte Informatik", "AI"),
    MI (2, "Medien Informatik", "MI"),
    WI (3, "Wirtschafts Informatik", "WI");

    private final String name;
    private final String shortName;
    private final int id;

    FieldOfStudies(int id, String name, String shortName) {
        this.name = name; this.shortName = shortName; this.id = id;
    }

    public String getCourseName () {
        return name;
    }

    public String getShortName() {
        return shortName;
    }

    public static String[] getNames() {
        return Arrays.stream(FieldOfStudies.values())
                .map(FieldOfStudies::getCourseName)
                .toArray(String[]::new);
    }
}
