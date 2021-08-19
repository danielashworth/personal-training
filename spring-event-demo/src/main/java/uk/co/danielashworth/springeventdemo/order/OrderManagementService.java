package uk.co.danielashworth.springeventdemo.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
class OrderManagementService {

  private final OrderRepository orderRepository;

  @Autowired
  OrderManagementService(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  @Transactional
  public void completeOrder(Order order) {
    order.complete();
    saveOrder(order);
  }

  @Transactional
  public void delayOrder(Order order) {
    order.delay();
    saveOrder(order);
  }

  void saveOrder(Order order) {
    orderRepository.save(order);
  }

}
