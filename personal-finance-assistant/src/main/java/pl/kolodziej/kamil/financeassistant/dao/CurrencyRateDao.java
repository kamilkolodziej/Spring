package pl.kolodziej.kamil.financeassistant.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import pl.kolodziej.kamil.financeassistant.dto.CurrencyRate;

public interface CurrencyRateDao {
	BigDecimal getRate(String currency, Date rateDate);
	CurrencyRate getRateInfo(String currency, Date rateDate);
	void addRate(CurrencyRate currencyRate);
	void addManyRates(List<CurrencyRate> currencyRates);
	void updateRate(String currency, BigDecimal rate);
	void deleteRate(String currency);
}
