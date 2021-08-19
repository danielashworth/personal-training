package uk.co.danielashworth.springevents.order;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface OrderRepository extends CrudRepository<Order, Integer> {
}
