package uk.co.danielashworth.springeventdemo.order;

public class OrderDelayedEvent extends AbstractOrderEvent {

  OrderDelayedEvent(Order order) {
    super(order);
  }
}
