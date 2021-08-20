package uk.co.danielashworth.springcache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@CacheConfig(cacheNames = "cars")
class CarService {

  private final SimpleCarRepository simpleCarRepository;

  @Autowired
  CarService(SimpleCarRepository simpleCarRepository) {
    this.simpleCarRepository = simpleCarRepository;
  }

  @CachePut(key = "#carId")
  public Car updateCar(int carId) {
    return new Car(carId, "new name");
  }

  @CacheEvict(allEntries = true)
  public void clearCache() {
    //
  }

  @Cacheable(key = "#carId")
  public Car getCar(int carId) {
    log.info("Entering getCar method");
    return simpleCarRepository.findById(carId);
  }
}
