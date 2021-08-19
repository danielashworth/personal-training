package uk.co.danielashworth.springevents.order;

public class OrderDelayedEvent extends AbstractOrderEvent {

  OrderDelayedEvent(Order order) {
    super(order);
  }
}
