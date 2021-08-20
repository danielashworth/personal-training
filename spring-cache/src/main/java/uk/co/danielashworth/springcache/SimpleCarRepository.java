package uk.co.danielashworth.springcache;

import org.springframework.stereotype.Component;

@Component
class SimpleCarRepository {

  Car findById(int id) {
    simulateSlowRepositoryResponse();
    return new Car(id, "name");
  }

  private void simulateSlowRepositoryResponse() {
    try {
      long time = 3000L;
      Thread.sleep(time);
    } catch (InterruptedException e) {
      throw new IllegalStateException(e);
    }
  }

}
