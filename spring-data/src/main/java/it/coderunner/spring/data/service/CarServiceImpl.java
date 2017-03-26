package it.coderunner.spring.data.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.coderunner.spring.data.dao.CarRepository;
import it.coderunner.spring.data.model.Car;

@Service
public class CarServiceImpl implements CarService{

	private static final long serialVersionUID = -5212497294563141450L;
	
	@Resource
	private CarRepository carRepository;

	@Override
	public Car findByBrandAndColorAllIgnoringCase(String brand, String color) {
		return carRepository.findByBrandAndColorAllIgnoringCase(brand, color) ;
	}

	@Override
	public Car save(Car car) {
		return carRepository.save(car);
	}

	@Override
	public List<Car> findFirst10ByColor(String color) {
		return carRepository.findFirst10ByColor(color);
	}

	@Override
	public Page<Car> findAll(Pageable pageable) {
		return carRepository.findAll(pageable);
	}

}