package uk.co.danielashworth.springeventdemo.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

  private final OrderManagementService orderManagementService;

  @Autowired
  public OrderController(OrderManagementService orderManagementService) {
    this.orderManagementService = orderManagementService;
  }

  @GetMapping("/complete")
  public String completeOrder() {
    orderManagementService.completeOrder(new Order());
    return "order complete";
  }

  @GetMapping("/delay")
  public String delayOrder() {
    orderManagementService.delayOrder(new Order());
    return "order delayed";
  }
}
