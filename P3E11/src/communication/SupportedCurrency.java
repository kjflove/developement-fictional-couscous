package communication;

/**
 * Class description ...
 * Included in PACKAGE_NAME
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 30. Jun 2017
 */
public enum SupportedCurrency {
    EUR("Euro") {
        public double exchange(double money){ return money * EXCHANGE_VALUE; }
        public CurrencyData createData(double money){
            return new CurrencyData(EUR, DM, money);
        }
    },
    DM ("Deutsche Mark") {
        public double exchange(double money){
            return money / EXCHANGE_VALUE;
        }
        public CurrencyData createData(double money){
            return new CurrencyData(DM, EUR, money);
        }
    };

    public abstract double exchange(double money);
    public abstract CurrencyData createData(double money);
    private static final double EXCHANGE_VALUE = 1.95583d;
    public String name;

    SupportedCurrency(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
