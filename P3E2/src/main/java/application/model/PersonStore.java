package application.model;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Class description ...
 * Included in application.model
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 21. Apr 2017
 */
public class PersonStore<E extends Person> extends LinkedList<E> {

    /**
     * Constructs an empty list.
     */
    public PersonStore() {
        super();
    }

    /**
     * Constructs a list containing the elements of the specified
     * collection, in the order they are returned by the collection's
     * iterator.
     *
     * @param c the collection whose elements are to be placed into this list
     * @throws NullPointerException if the specified collection is null
     */
    public PersonStore(Collection<? extends E> c) {
        super(c);
    }

    public boolean addStudent(E e){
        // add some checks here ?! :D
        return this.add(e);
    }

}
