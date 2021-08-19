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
  int deriveNumberFallback(ShakyBusinessException ex) {
    log.info("Entered deriveNumberFallback method");
    return 2;
  }

  @Retryable(include = ShakyBusinessException.class)
  int deriveNumber() throws Exception {

    log.info("Entered deriveNumber method");

    if (Math.random() > 0.5) {
      log.info("Entered deriveNumber failure condition");
      Thread.sleep(3000);
      throw new ShakyBusinessException("Crash!");
    }

    return 1;
  }
}
