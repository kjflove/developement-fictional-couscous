package application;

import javafx.beans.property.SimpleIntegerProperty;

import java.io.Serializable;

/**
 * Class description ...
 * Included in application
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 19. Jun 2017
 */
public class StudentData implements Serializable {

    private static final long serialVersionUID = 42312132L;
    private SimpleIntegerProperty
            percentBachelor = new SimpleIntegerProperty(),
            percentUniversity = new SimpleIntegerProperty(),
            percentRest = new SimpleIntegerProperty();

    private StudentData(){}

    public StudentData(int percentBachelor, int percentUniversity) throws IllegalAccessException{
        if(percentBachelor + percentUniversity > 100)
            throw new IllegalAccessException("PercentBachelor and Percent University must be below 100%.");

        this.percentBachelor.setValue(percentBachelor);
        this.percentUniversity.setValue(percentUniversity);
        this.percentRest.setValue(100 - (percentBachelor + percentUniversity));
    }

    public int getPercentBachelor() {
        return percentBachelor.get();
    }

    public SimpleIntegerProperty percentBachelorProperty() {
        return percentBachelor;
    }

    public int getPercentUniversity() {
        return percentUniversity.get();
    }

    public SimpleIntegerProperty percentUniversityProperty() {
        return percentUniversity;
    }

    public int getPercentRest() {
        return percentRest.get();
    }

    public SimpleIntegerProperty percentRestProperty() {
        return percentRest;
    }
}
