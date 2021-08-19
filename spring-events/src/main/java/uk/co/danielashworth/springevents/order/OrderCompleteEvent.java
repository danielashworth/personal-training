package uk.co.danielashworth.springevents.order;

public class OrderCompleteEvent extends AbstractOrderEvent {

  OrderCompleteEvent(Order order) {
    super(order);
  }
}
