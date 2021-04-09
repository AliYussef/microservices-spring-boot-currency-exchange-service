package ay.microservices.currencyexchangeservice.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by aliyussef on 09/04/2021
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorDetails {
    private String message;
    private String details;
    private Date timestamp;
    private int statusCode;
}
