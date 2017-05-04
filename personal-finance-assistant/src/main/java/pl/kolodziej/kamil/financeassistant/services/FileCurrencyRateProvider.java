package pl.kolodziej.kamil.financeassistant.services;

import java.math.BigDecimal; 
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FileCurrencyRateProvider implements CurrencyRateProvider {
	
	@Value("${filename:default.xml}")
	private String fileName;

	public BigDecimal getRate(String rate, Date rateDate) {
		System.out.println("FileCurrencyRateProvider: File loaded. "+fileName);
		return BigDecimal.valueOf(4.25);
	}

}
