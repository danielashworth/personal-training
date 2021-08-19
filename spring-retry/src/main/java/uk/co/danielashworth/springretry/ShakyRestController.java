package uk.co.danielashworth.springretry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ShakyRestController {

  private final ShakyBusinessService shakyBusinessService;

  @Autowired
  ShakyRestController(ShakyBusinessService shakyBusinessService) {
    this.shakyBusinessService = shakyBusinessService;
  }

  @GetMapping("/crash")
  public int crashEndpoint() throws Exception {
    return shakyBusinessService.deriveNumber();
  }
}
