package ay.microservices.currencyexchangeservice.services;

import ay.microservices.currencyexchangeservice.exceptions.NotFoundException;
import ay.microservices.currencyexchangeservice.models.CurrencyExchange;
import ay.microservices.currencyexchangeservice.repositories.CurrencyExchangeRepository;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/**
 * Created by aliyussef on 09/04/2021
 */
@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {

    private final Environment environment;
    private final CurrencyExchangeRepository currencyExchangeRepository;

    public CurrencyExchangeServiceImpl(Environment environment, CurrencyExchangeRepository currencyExchangeRepository) {
        this.environment = environment;
        this.currencyExchangeRepository = currencyExchangeRepository;
    }

    @Override
    public CurrencyExchange getExchangeValueFor(String from, String to) {
        CurrencyExchange currencyExchange = currencyExchangeRepository.findByFromAndTo(from, to);
        if (currencyExchange == null) {
            throw new NotFoundException("Currency exchange does not exist!");
        }
        currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
        return currencyExchange;
    }
}
