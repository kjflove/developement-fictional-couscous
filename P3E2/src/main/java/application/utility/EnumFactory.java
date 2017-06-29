package application.utility;

import java.util.EnumSet;

/**
 * Class description ...
 * Included in application.utility
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 24. Apr 2017
 */

public class EnumFactory<T extends Enum<T>>
        implements IRandomable<T>
{
    private final Class<T> clazz;

    public EnumFactory(Class<T> clazz)
    {
        this.clazz = clazz;
    }

    @Override
    public T randomEnum() {
        EnumSet<T> k = EnumSet.allOf(clazz);

        int idx = 0;
        int getId = (int) Math.floor(Math.random() * k.size());

        for (T t : k) {
            if(idx++ == getId){
                return t;
            }
        }

        return null;
    }
}
