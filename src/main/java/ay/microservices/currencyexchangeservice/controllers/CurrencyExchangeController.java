package ay.microservices.currencyexchangeservice.controllers;

import ay.microservices.currencyexchangeservice.models.CurrencyExchange;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * Created by aliyussef on 09/04/2021
 */
@RestController
@RequestMapping("api/v1/currencyExchange")
public class CurrencyExchangeController {

    @GetMapping("from/{from}/to/{to}")
    @ResponseStatus(HttpStatus.OK)
    public CurrencyExchange getExchangeValue(@PathVariable String from, @PathVariable String to) {
        return CurrencyExchange.builder()
                .id(100L)
                .from(from)
                .to(to)
                .conversionMultiple(BigDecimal.valueOf(50))
                .build();
    }

}
