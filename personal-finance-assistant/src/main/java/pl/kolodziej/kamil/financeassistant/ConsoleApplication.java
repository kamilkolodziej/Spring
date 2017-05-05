package pl.kolodziej.kamil.financeassistant;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.ParseException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.kolodziej.kamil.financeassistant.dto.CurrencyRate;
import pl.kolodziej.kamil.financeassistant.services.RateCrudService;
import pl.kolodziej.kamil.financeassistant.services.RateConversionService;

public class ConsoleApplication {

	public static void main(String[] args) throws ParseException {

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		RateConversionService service = context.getBean(RateConversionService.class);
		service.convertAmount(BigDecimal.valueOf(10), "EUR");
		
		RateCrudService crudService = context.getBean(RateCrudService.class);
		
		List<CurrencyRate> currencyRateList = new ArrayList<CurrencyRate>();
		for (int i = 0; i < 10; i++) {
			currencyRateList.add(new CurrencyRate("USD", new Date(), BigDecimal.valueOf(7.33)));
		}
		
		crudService.storeRate(new CurrencyRate("USD", new Date(), BigDecimal.valueOf(4.5)));
		crudService.storeRate(new CurrencyRate("CZK", new Date(), BigDecimal.valueOf(1.5)));
		crudService.storeManyRates(currencyRateList);
		crudService.updateRate("EUR", BigDecimal.valueOf(6.1));
		crudService.deleteRate("CZK");

	}
}
