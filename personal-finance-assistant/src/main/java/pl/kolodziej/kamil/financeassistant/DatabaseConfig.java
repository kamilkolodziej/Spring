package pl.kolodziej.kamil.financeassistant;

import javax.sql.DataSource; 

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pl.kolodziej.kamil.financeassistant.dao.CurrencyRateDao;
import pl.kolodziej.kamil.financeassistant.dao.JdbcCurrencyRateDao;
import pl.kolodziej.kamil.financeassistant.services.RateCrudService;

@Configuration
public class DatabaseConfig {
	
	@Bean
	public DataSource dataSource() {
		BasicDataSource source = new BasicDataSource();
		source.setDriverClassName("org.h2.Driver");
		source.setUrl("jdbc:h2:~/database_pfa;INIT= runscript from 'classpath:/create.sql'");
		source.setUsername("SA");
		return source;
	}
	
	@Bean
	public CurrencyRateDao currencyRateDao() {
		return new JdbcCurrencyRateDao();
	}
	
	@Bean
	public RateCrudService rateAddService() {
		return new RateCrudService();
	}
}
