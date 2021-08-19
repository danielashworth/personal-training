package uk.co.danielashworth.springevents.email;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uk.co.danielashworth.springevents.order.Order;

@Service
@Slf4j
class CustomerEmailService {

  void sendOrderCompleteEmail(Order order) {
    log.info(String.format("Sending order completed email for order - %s", order.toString()));
  }

  void sendOrderDelayedEmail(Order order) {
    log.info(String.format("Sending order delayed email for order - %s", order.toString()));
  }

}
