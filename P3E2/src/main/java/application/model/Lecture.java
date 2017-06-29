package application.model;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

/**
 * Class description ...
 * Included in PACKAGE_NAME
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 19. Apr 2017
 */
public class Lecture {

    private int semester;
    private String lecutreName;
    private FieldOfStudies course;

    public Lecture(@NotNull int semester, String lecutreName, @Nullable FieldOfStudies course) {
        this.semester = semester;
        this.lecutreName = lecutreName;
        this.course = course;
    }

    public Lecture() {
    }
}
