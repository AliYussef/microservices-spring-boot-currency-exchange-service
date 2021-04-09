package ay.microservices.currencyexchangeservice.services;

import ay.microservices.currencyexchangeservice.models.CurrencyExchange;

/**
 * Created by aliyussef on 09/04/2021
 */
public interface CurrencyExchangeService {
    CurrencyExchange getExchangeValueFor(String from, String to);
}
