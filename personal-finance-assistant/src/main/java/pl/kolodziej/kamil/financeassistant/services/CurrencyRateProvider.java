package pl.kolodziej.kamil.financeassistant.services;

import java.math.BigDecimal;
import java.util.Date;

public interface CurrencyRateProvider {
	public BigDecimal getRate(String rate, Date rateDate);
}
