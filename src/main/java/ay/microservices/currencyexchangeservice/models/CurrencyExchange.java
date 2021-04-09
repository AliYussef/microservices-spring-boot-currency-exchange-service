package ay.microservices.currencyexchangeservice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by aliyussef on 09/04/2021
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class CurrencyExchange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "currency_from") //db will accept from/to name as it is a keyword of SQL syntax.
    private String from;
    @Column(name = "currency_to")
    private String to;
    private BigDecimal conversionMultiple;
    private String environment; // to be able to know which instance we are using
}
