package application.model;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAmount;
import java.util.List;

/**
 * Class description ...
 * Included in application.model
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 21. Apr 2017
 */
public class Student extends Person {

    private int mn;
    private int semester;
    private FieldOfStudies fieldOfStudies;
    private List<Courses> courses;
    public Student(String surname, String name, LocalDate birthday, Gender gender, int mn, int semester, FieldOfStudies fieldOfStudies, List<Courses> courses)
        throws InvalidArgumentException {
        super(surname, name, birthday, gender);
        this.mn = mn;
        this.semester = semester;
        this.fieldOfStudies = fieldOfStudies;
        this.courses = courses;
    }

    public FieldOfStudies getFieldOfStudies() {
        return fieldOfStudies;
    }

    public boolean checkIfValid(Student e){
        return false;
    }

    @Override
    public String toString() {
        // int yearsOld = getBirthday().minus();
        return "[" + getFieldOfStudies().getShortName() +
                "/" + mn + "] "
                + getSurname() + ", "
                + getName() + " born on "
                + getBirthday().format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
