package application.utility;

import application.model.*;
import com.sun.javaws.exceptions.InvalidArgumentException;

import java.time.LocalDate;
import java.util.*;

/**
 * Class description ...
 * Included in application.utility
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 25. Apr 2017
 */
public class StudentFactory {
    private static Map<String, Gender> dictionary = new HashMap<String, Gender>();
    public static PersonStore<Student> listOfStudents = new PersonStore<>();

    static {
        dictionary.put("Johnie, Jaques", Gender.MALE);
        dictionary.put("Meagan, Meshell", Gender.FEMALE);
        dictionary.put("Lovetta, Leite", Gender.FEMALE);
        dictionary.put("Wesley, Willems", Gender.MALE);
        dictionary.put("Tynisha, Thomure", Gender.FEMALE);
        dictionary.put("Carmon, Claunch", Gender.MALE);
        dictionary.put("Criselda, Cockett", Gender.FEMALE);
        dictionary.put("Alonzo, Arellano", Gender.MALE);
        dictionary.put("Librada, Luthy", Gender.FEMALE);
        dictionary.put("Natalie, Narciso", Gender.FEMALE);
        dictionary.put("Ervin, Engelmann", Gender.MALE);
        dictionary.put("Lavona, Leth", Gender.FEMALE);


        EnumFactory<FieldOfStudies> FieldFactory = new EnumFactory<>(FieldOfStudies.class);
        EnumFactory<Courses> CourseFactory = new EnumFactory<>(Courses.class);

        dictionary.forEach((name, gender) -> {

            String[] nameArray = name.split(", ");
            Courses[] ar = {CourseFactory.randomEnum(), CourseFactory.randomEnum(), CourseFactory.randomEnum()};
            try{
                listOfStudents.add(new Student(
                        nameArray[0],
                        nameArray[1],
                        LocalDate.now(),
                        gender,
                        (int)(Math.random()*20000),
                        (int)(Math.random() * 5 + 1),
                        FieldFactory.randomEnum(),
                        new LinkedList<Courses>(Arrays.asList(ar))
                ));
            } catch (Exception e){
                e.printStackTrace();
            }

        });

    }



}
