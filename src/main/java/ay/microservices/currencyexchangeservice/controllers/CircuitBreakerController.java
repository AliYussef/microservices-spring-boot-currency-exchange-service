package ay.microservices.currencyexchangeservice.controllers;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by aliyussef on 09/04/2021
 */
@RestController
public class CircuitBreakerController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Bulkhead(name = "default") //concurrency calling solution
    @RateLimiter(name = "default") //ip rate limiting
    @Retry(name = "sample-api", fallbackMethod = "fallbackResponse") // retry policy
    @CircuitBreaker(name = "default", fallbackMethod = "fallbackResponse") //whole solution retry policy
    @GetMapping("/sample-api")
    @ResponseStatus(HttpStatus.OK)
    public String sampleApi() {
        logger.info("Sample api received!");
        ResponseEntity<String> responseEntity = new RestTemplate()
                .getForEntity("http://localhost:8080/dummycall", String.class);

        return responseEntity.getBody();
    }

    //we can have different fallback methods for different exception types
    public String fallbackResponse(Exception ex) {
        return "Fallback Response";
    }
}
