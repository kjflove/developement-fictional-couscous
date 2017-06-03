package application.gamescene.factories;

import java.util.Collection;

/**
 * Class description ...
 * Included in application.gamescene.factories
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 26. Mai 2017
 */
public class FunctionalForEach {

    @FunctionalInterface
    public interface LoopWithIndexAndSizeConsumer<T> {
        void accept(T t, int i, int n);
    }

    public static <T> void forEach(Collection<T> collection,
                                   LoopWithIndexAndSizeConsumer<T> consumer) {
        int index = 0;
        for (T object : collection){
            consumer.accept(object, index++, collection.size());
        }
    }
}
