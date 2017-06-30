package communication;

import java.io.Serializable;

/**
 * Class description ...
 * Included in PACKAGE_NAME
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 30. Jun 2017
 */
public class CurrencyData implements Serializable {
    static final long serialVersionUID = 1337L;

    private SupportedCurrency fromCurrency;
    private SupportedCurrency toCurrency;
    private double moneyToExchange;

    public SupportedCurrency getFromCurrency() {
        return fromCurrency;
    }

    public SupportedCurrency getToCurrency() {
        return toCurrency;
    }

    public double getMoneyToExchange() {
        return moneyToExchange;
    }

    public CurrencyData(SupportedCurrency fromCurrency, SupportedCurrency toCurrency, double moneyToExchange) {

        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.moneyToExchange = moneyToExchange;
    }
}
