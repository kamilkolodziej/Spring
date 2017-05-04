package pl.kolodziej.kamil.financeassistant;

import org.springframework.context.annotation.Bean; 
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import pl.kolodziej.kamil.financeassistant.services.RateConversionService;

@Configuration
@Import(DatabaseConfig.class)
public class AppConfigCommon {
	
	@Bean
	public RateConversionService rateConversionService() {
		RateConversionService rateConversionService = new RateConversionService();
		return rateConversionService;
	}
}
