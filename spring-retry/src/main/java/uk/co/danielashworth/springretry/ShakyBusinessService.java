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
  String fallbackMethod(ShakyBusinessException ex) {
    log.info("Entered fallbackMethod method");
    return "fallback response";
  }

  @Retryable(include = ShakyBusinessException.class, maxAttempts = 2)
  String retryableMethod() throws Exception {

    log.info("Entered retryableMethod method");

    if (hasRequestFailed()) {
      log.info("Entered retryableMethod failure condition");
      triggerShakyBusinessException();
    }

    return "standard response";
  }

  @CircuitBreaker(include = ShakyBusinessException.class, maxAttempts = 1)
  String circuitBreakerMethod() throws Exception {

    log.info("Entered circuitBreakerMethod method");

    if (hasRequestFailed()) {
      log.info("Entered circuitBreakerMethod failure condition");
      triggerShakyBusinessException();
    }

    return "standard response";
  }

  private boolean hasRequestFailed() {
    return Math.random() > 0.5;
  }

  private void triggerShakyBusinessException() throws Exception {
    // sleep thread to mimic a request to a third party service
    Thread.sleep(3000);
    throw new ShakyBusinessException("ShakyBusinessException!");
  }

}
