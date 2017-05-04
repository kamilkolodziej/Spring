package pl.kolodziej.kamil.financeassistant;

import org.springframework.context.annotation.Bean; 
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import pl.kolodziej.kamil.financeassistant.services.CurrencyRateProvider;
import pl.kolodziej.kamil.financeassistant.services.DatabaseCurrencyRateProvider;

@Configuration
@Import(AppConfigCommon.class)
@Profile("prod")
@PropertySource({ "classpath:app.properties"})
public class AppConfig {

	@Bean
	public CurrencyRateProvider databaseCurrencyRateProvider() {
		return new DatabaseCurrencyRateProvider();
	}
}
