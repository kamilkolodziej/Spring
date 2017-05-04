package pl.kolodziej.kamil.financeassistant.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.kolodziej.kamil.financeassistant.dao.CurrencyRateDao;
import pl.kolodziej.kamil.financeassistant.dto.CurrencyRate;

@Service
public class RateCrudService {
	
	@Autowired
	private CurrencyRateDao currencyRateDao;
	
	public void storeRate(CurrencyRate currencyRate) {
		currencyRateDao.addRate(currencyRate);
	}
	
	public void storeManyRates(List<CurrencyRate> currencyRate) {
		currencyRateDao.addManyRates(currencyRate);
	}
	
	public void updateRate(String currency, BigDecimal rate) {
		currencyRateDao.updateRate(currency, rate);
	}
	
	public void deleteRate(String currency) {
		currencyRateDao.deleteRate(currency);
	}

}
