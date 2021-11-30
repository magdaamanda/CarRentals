package syksy2021.CarRentals.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import syksy2021.CarRentals.domain.Car;
import syksy2021.CarRentals.domain.CarRepository;
import syksy2021.CarRentals.domain.ModelRepository;

@RestController
public class RestCarController {
	
	@Autowired
	CarRepository carRepository;
	
	@Autowired
	ModelRepository modelRepository;
	
	//read cars from db
	@GetMapping(value="/cars")
	public List<Car> carListRest() {
		System.out.println("RestCarController: /cars");
		return (List<Car>) carRepository.findAll();
	}
	
	//insert new car to db
	@RequestMapping(value="/cars", method = RequestMethod.POST)
	public List<Car> saveCar(@RequestBody Car car) {
		System.out.println("RestCarController: cars-POST method saveCar");
		carRepository.save(car);
		return (List<Car>) carRepository.findAll();
	}
}