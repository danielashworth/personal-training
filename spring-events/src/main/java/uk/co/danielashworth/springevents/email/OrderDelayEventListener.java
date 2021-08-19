package uk.co.danielashworth.springevents.email;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import uk.co.danielashworth.springevents.order.OrderDelayedEvent;

@Component
@Slf4j
class OrderDelayEventListener {

  private final CustomerEmailService customerEmailService;

  @Autowired
  OrderDelayEventListener(CustomerEmailService customerEmailService) {
    this.customerEmailService = customerEmailService;
  }

  @EventListener
  public void onOrderDelay(OrderDelayedEvent event) {
    log.info(String.format(
        "Received OrderDelayedEvent for order - %s",
        event.getOrder().toString()
    ));
    customerEmailService.sendOrderDelayedEmail(event.getOrder());
  }
}
