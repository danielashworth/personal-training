package uk.co.danielashworth.springcache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class CarController {

  private final CarService carService;

  @Autowired
  public CarController(CarService carService) {
    this.carService = carService;
  }

  @GetMapping("/{carId}")
  public ResponseEntity<Car> getCar(@PathVariable("carId") int carId) {
    return new ResponseEntity<>(carService.getCar(carId), HttpStatus.OK);
  }

  @GetMapping("/{carId}/update")
  public ResponseEntity<Car> updateCar(@PathVariable("carId") int carId) {
    return new ResponseEntity<>(carService.updateCar(carId), HttpStatus.OK);
  }

  @GetMapping("/clear")
  public ResponseEntity<String> clearCarCache() {
    carService.clearCache();
    return new ResponseEntity<>("car cache cleared", HttpStatus.OK);
  }
}
