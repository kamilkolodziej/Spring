package pl.kolodziej.kamil.financeassistant.services;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.kolodziej.kamil.financeassistant.dao.CurrencyRateDao;
import pl.kolodziej.kamil.financeassistant.dto.CurrencyRate;

@Service
public class DatabaseCurrencyRateProvider implements CurrencyRateProvider {

	@Autowired
	private CurrencyRateDao currencyRateDao;
	
	public BigDecimal getRate(String currency, Date rateDate) {
		BigDecimal rate = currencyRateDao.getRate(currency, rateDate);
		CurrencyRate currencyRate = currencyRateDao.getRateInfo(currency, rateDate);
		System.out.println(currencyRate);
		System.out.println("DatabaseCurrencyRateProvider: Database loaded rate = "+rate);
		return rate;
	}
}
