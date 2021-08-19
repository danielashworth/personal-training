package uk.co.danielashworth.springeventdemo.order;

public class OrderCompleteEvent extends AbstractOrderEvent {

  OrderCompleteEvent(Order order) {
    super(order);
  }
}
