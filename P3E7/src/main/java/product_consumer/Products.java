package product_consumer;

import java.util.LinkedList;
import java.util.List;

/**
 * Class description ...
 * Included in product_consumer
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 02. Jun 2017
 */
public class Products {

    private static List<Integer> container = new LinkedList<>();

    public synchronized static int removeProduct() throws IllegalAccessException{
        if(container.size() > 0)
            return container.remove(container.size()-1);
        else
            throw new IllegalAccessException();
    }

    public synchronized static void insertProduct(int toAdd){
        container.add(toAdd);
    }
}
