package ay.microservices.currencyexchangeservice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Created by aliyussef on 09/04/2021
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CurrencyExchange {
    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
}
