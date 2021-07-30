package uk.co.danielashworth.springeventdemo.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@Slf4j
public class Order extends AbstractAggregateRoot<Order> {

  @Id
  @GeneratedValue
  private int id;

  @Enumerated(EnumType.STRING)
  private OrderStatus orderStatus;

  protected Order() {
    this.orderStatus = OrderStatus.IN_PROGRESS;
  }

  void complete() {
    orderStatus = OrderStatus.COMPLETE;
    log.info(String.format(
        "Completing order in domain object for order %s",
        this
    ));
    registerEvent(new OrderCompleteEvent(this));
  }

  void delay() {
    orderStatus = OrderStatus.DELAYED;
    log.info(String.format(
        "Delaying order in domain object for order %s",
        this
    ));
    registerEvent(new OrderDelayedEvent(this));
  }

  @Override
  public String toString() {
    return String.format(
        "ID: %d, ORDER_STATUS: %s",
        id,
        orderStatus
    );
  }

  enum OrderStatus {
    IN_PROGRESS,
    COMPLETE,
    DELAYED
  }
}
