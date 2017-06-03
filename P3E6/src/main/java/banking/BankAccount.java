package banking;

/**
 * Class description ...
 * Included in banking
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 31. Mai 2017
 */
public class BankAccount {

    private long value = 0;

    public void addValue(int add) {
        if (add <= 0) return;
        synchronized (this) {
            this.value += add;
        }
    }

    public long getValue() {
        return value;
    }
}
