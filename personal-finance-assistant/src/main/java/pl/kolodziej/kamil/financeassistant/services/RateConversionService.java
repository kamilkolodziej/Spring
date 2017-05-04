package pl.kolodziej.kamil.financeassistant.services;

import java.math.BigDecimal;  
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RateConversionService {
	
	private CurrencyRateProvider rateProvider;
	
	@Autowired
	public void setRateProvider(CurrencyRateProvider rateProvider) {
		this.rateProvider = rateProvider;
	}
	
	public BigDecimal convertAmount(BigDecimal amount, String currency) throws ParseException {
		Date date = (new SimpleDateFormat("yyyy-MM-dd")).parse("2017-04-27");
		BigDecimal rate = rateProvider.getRate(currency, date);
		System.out.println("RateConversionService: Calculate amount");
		BigDecimal result = amount.multiply(rate).setScale(2, RoundingMode.HALF_UP);
		System.out.println("Result =" + result);
		return result;
	}

}
