package application.model;

import java.util.Arrays;
import java.util.List;

/**
 * Class description ...
 * Included in application.model
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 21. Apr 2017
 */
public enum Courses {
    MATHS(1, Arrays.asList(FieldOfStudies.AI, FieldOfStudies.MI, FieldOfStudies.WI)),
    GERMAN(1, Arrays.asList(FieldOfStudies.AI, FieldOfStudies.MI, FieldOfStudies.WI)),
    ENGLISH(1, Arrays.asList(FieldOfStudies.AI, FieldOfStudies.MI, FieldOfStudies.WI)),
    PROGRAMMING(1, Arrays.asList(FieldOfStudies.AI, FieldOfStudies.MI, FieldOfStudies.WI)),
    NETWORKING(1, Arrays.asList(FieldOfStudies.AI, FieldOfStudies.MI, FieldOfStudies.WI)),
    SPORTS(1, Arrays.asList(FieldOfStudies.AI, FieldOfStudies.MI, FieldOfStudies.WI)),
    OPERATION_SYSTEMS(1, Arrays.asList(FieldOfStudies.AI, FieldOfStudies.MI, FieldOfStudies.WI));

    private final List<FieldOfStudies> list;
    private final int id;

    Courses(int id, List<FieldOfStudies> col) {
        list = col;
        this.id = id;
    }

    public List<FieldOfStudies> getList() {
        return list;
    }

    public int getId() {
        return id;
    }
}
