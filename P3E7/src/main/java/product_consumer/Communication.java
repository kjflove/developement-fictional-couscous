package product_consumer;

/**
 * Class description ...
 * Included in product_consumer
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 02. Jun 2017
 */
public enum Communication {
    PRODUCED_PRODUCT(1),
    STOPPED_PRODCUTION(2),
    FINISHED_CONSUMING(3);

    private final int number;

    Communication(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
