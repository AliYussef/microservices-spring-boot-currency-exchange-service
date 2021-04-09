package ay.microservices.currencyexchangeservice.controllers;

import ay.microservices.currencyexchangeservice.models.CurrencyExchange;
import ay.microservices.currencyexchangeservice.services.CurrencyExchangeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by aliyussef on 09/04/2021
 */
@RestController
@RequestMapping("api/v1/currencyExchange")
public class CurrencyExchangeController {

    private CurrencyExchangeService currencyExchangeService;

    public CurrencyExchangeController(CurrencyExchangeService currencyExchangeService) {
        this.currencyExchangeService = currencyExchangeService;
    }

    @GetMapping("from/{from}/to/{to}")
    @ResponseStatus(HttpStatus.OK)
    public CurrencyExchange getExchangeValue(@PathVariable String from, @PathVariable String to) {
        return currencyExchangeService.getExchangeValueFor(from, to);
    }

}
