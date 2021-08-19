package uk.co.danielashworth.springevents.order;

abstract class AbstractOrderEvent {

  private final Order order;

  AbstractOrderEvent(Order order) {
    this.order = order;
  }

  public Order getOrder() {
    return order;
  }
}
