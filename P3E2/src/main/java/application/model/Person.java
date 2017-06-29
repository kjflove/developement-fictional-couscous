package application.model;

import java.time.LocalDate;

/**
 * Class description ...
 * Included in PACKAGE_NAME
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 19. Apr 2017
 */
public abstract class Person {

    private String surname;
    private String name;
    private LocalDate birthday;
    private Gender gender;
    private String lieblingsTier = "Katze";


    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    Person(String surname, String name, LocalDate birthday, Gender gender) {
        this.surname = surname;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (surname != null ? !surname.equals(person.surname) : person.surname != null) return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        return birthday != null ? birthday.equals(person.birthday) : person.birthday == null;
    }

    @Override
    public int hashCode() {
        int result = surname != null ? surname.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "application.model.Person{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}


