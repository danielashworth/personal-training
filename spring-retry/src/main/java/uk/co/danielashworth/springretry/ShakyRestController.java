package uk.co.danielashworth.springretry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crash")
class ShakyRestController {

  private final ShakyBusinessService shakyBusinessService;

  @Autowired
  ShakyRestController(ShakyBusinessService shakyBusinessService) {
    this.shakyBusinessService = shakyBusinessService;
  }

  @GetMapping("/retry")
  public String retryEndpoint() throws Exception {
    return shakyBusinessService.retryableMethod();
  }

  @GetMapping("/circuit-breaker")
  public String circuitBreakerEndpoint() throws Exception {
    return shakyBusinessService.circuitBreakerMethod();
  }
}
