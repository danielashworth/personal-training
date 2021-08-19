package uk.co.danielashworth.springeventdemo.order;

abstract class AbstractOrderEvent {

  private final Order order;

  AbstractOrderEvent(Order order) {
    this.order = order;
  }

  public Order getOrder() {
    return order;
  }
}
