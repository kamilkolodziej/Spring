package pl.kolodziej.kamil.financeassistant.dao;

import java.math.BigDecimal; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import pl.kolodziej.kamil.financeassistant.dto.CurrencyRate;

@Repository
public class JdbcCurrencyRateDao implements CurrencyRateDao {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public BigDecimal getRate(String currency, Date rateDate) {
		return jdbcTemplate.queryForObject("select rate from currency_rates where currency=? and rate_date=?",
				new Object[] { currency, new java.sql.Date(rateDate.getTime()) }, BigDecimal.class);
	}

	public CurrencyRate getRateInfo(String currency, Date rateDate) {
		return jdbcTemplate.queryForObject("select * from currency_rates where currency=? and rate_date=?",
				new Object[] { currency, new java.sql.Date(rateDate.getTime()) }, new RowMapper<CurrencyRate>() {

					public CurrencyRate mapRow(ResultSet rs, int rowNum) throws SQLException {
						return new CurrencyRate(rs.getNString("CURRENCY"), rs.getDate("RATE_DATE"),
								rs.getBigDecimal("RATE"));
					}
				});
	}

	public void addRate(CurrencyRate currencyRate) {
		jdbcTemplate.update("insert into currency_rates (currency, rate_date, rate) values (?, ?, ?)",
				currencyRate.getCurrency(), new java.sql.Date(currencyRate.getRateDate().getTime()),
				currencyRate.getRate());
	}

	public void addManyRates(final List<CurrencyRate> currencyRates) {
		jdbcTemplate.batchUpdate("insert into currency_rates (currency, rate_date, rate) values (?, ?, ?)", 
				new BatchPreparedStatementSetter() {
			
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setString(1, currencyRates.get(i).getCurrency());
				ps.setDate(2, new java.sql.Date(currencyRates.get(i).getRateDate().getTime()));
				ps.setBigDecimal(3, currencyRates.get(i).getRate());
			}
			
			public int getBatchSize() {
				return currencyRates.size();
			}
		});
	}
	
	public void updateRate(String currency, BigDecimal rate) {
		jdbcTemplate.update("update currency_rates set rate = ? where currency = ? ", rate, currency); 
	}
	
	public void deleteRate(String currency) {
		jdbcTemplate.update("delete from currency_rates where currency = ?", currency);
	}
}
