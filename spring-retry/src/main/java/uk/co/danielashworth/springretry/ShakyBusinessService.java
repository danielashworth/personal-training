package uk.co.danielashworth.springretry;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.CircuitBreaker;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
class ShakyBusinessService {

  @Recover
  String retryableMethodFallback(ShakyBusinessException ex) {
    log.info("Entered retryableMethodFallback method");
    return "fallback response";
  }

  @Retryable(include = ShakyBusinessException.class)
  String retryableMethod() throws Exception {

    log.info("Entered retryableMethod method");

    if (Math.random() > 0.5) {
      log.info("Entered retryableMethod failure condition");
      Thread.sleep(3000);
      throw new ShakyBusinessException("Crash!");
    }

    return "standard response";
  }

  @Recover
  String circuitBreakerMethodFallback(ShakyBusinessException ex) {
    log.info("Entered circuitBreakerMethodFallback method");
    return "fallback response";
  }

  @CircuitBreaker(include = ShakyBusinessException.class, maxAttempts = 1)
  String circuitBreakerMethod() throws Exception {

    log.info("Entered circuitBreakerMethod method");

    if (Math.random() > 0.5) {
      log.info("Entered circuitBreakerMethod failure condition");
      Thread.sleep(3000);
      throw new ShakyBusinessException("Crash!");
    }

    return "standard response";
  }

}
