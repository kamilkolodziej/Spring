create table if not exists currency_rates (CURRENCY VARCHAR2(3) NOT NULL, RATE_DATE Date, RATE DECIMAL);
delete currency_rates;
insert into currency_rates (CURRENCY, RATE_DATE, RATE) values ('EUR', '2017-04-27', 4.35);
commit;