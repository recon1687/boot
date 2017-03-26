package it.coderunner.spring.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import it.coderunner.spring.data.model.Car;
import it.coderunner.spring.data.service.CarService;

@Controller
public class CarController {

	@Autowired
	private CarService carService;

	@GetMapping("/get/car/{brand}/{color}")
	public @ResponseBody ResponseEntity<String> getByBrandAndColor(@PathVariable String brand,
			@PathVariable String color) {
		Car car = carService.findByBrandAndColorAllIgnoringCase(brand, color);
		return car != null ? new ResponseEntity<String>("GET Response : " + car, HttpStatus.OK)
				: new ResponseEntity<String>("No car found", HttpStatus.NOT_FOUND);
	}

	@GetMapping("/save/car/{brand}/{color}")
	public @ResponseBody ResponseEntity<String> saveCar(@PathVariable String brand, @PathVariable String color) {
		Car car = carService.save(new Car(brand, color));
		return car != null ? new ResponseEntity<String>("GET Response : " + car, HttpStatus.OK)
				: new ResponseEntity<String>("Problem with saving", HttpStatus.NOT_FOUND);
	}

	@GetMapping("/get/top10/{color}")
	public @ResponseBody ResponseEntity<String> getTop10(@PathVariable String color) {
		List<Car> cars = carService.findFirst10ByColor(color);
		cars.stream().forEach(System.out::println);
		return cars != null && !cars.isEmpty()
				? new ResponseEntity<String>("GET Response : " + cars, HttpStatus.OK)
				: new ResponseEntity<String>("No cars found", HttpStatus.NOT_FOUND);
	}

	@GetMapping("/get/{page}/{size}")
	public @ResponseBody Page<Car> getTop10(@PathVariable Integer page, @PathVariable Integer size) {
		return carService.findAll(new PageRequest(page, size));
	}

}
