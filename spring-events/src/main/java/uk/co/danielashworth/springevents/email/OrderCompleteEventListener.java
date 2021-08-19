package uk.co.danielashworth.springevents.email;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import uk.co.danielashworth.springevents.order.OrderCompleteEvent;

@Component
@Slf4j
class OrderCompleteEventListener {

  private final CustomerEmailService customerEmailService;

  @Autowired
  OrderCompleteEventListener(CustomerEmailService customerEmailService) {
    this.customerEmailService = customerEmailService;
  }

  @EventListener
  public void onOrderComplete(OrderCompleteEvent event) {
    log.info(String.format(
        "Received OrderCompleteEvent for order - %s",
        event.getOrder().toString()
    ));
    customerEmailService.sendOrderCompleteEmail(event.getOrder());
  }
}
