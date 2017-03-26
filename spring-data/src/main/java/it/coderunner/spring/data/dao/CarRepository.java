package it.coderunner.spring.data.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import it.coderunner.spring.data.model.Car;

public interface CarRepository extends CrudRepository<Car, Long>{
	
	Page<Car> findAll(Pageable pageable);

	Page<Car> findByBrandContainingAndColorContainingAllIgnoringCase(String brand,
			String color, Pageable pageable);

	Car findByBrandAndColorAllIgnoringCase(String brand, String color);
	
	List<Car> findFirst10ByColor(String color);
	
	@SuppressWarnings("unchecked")
	Car save(Car car);

}