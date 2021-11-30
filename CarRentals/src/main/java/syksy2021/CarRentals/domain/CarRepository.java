package syksy2021.CarRentals.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {
	List<Car> findByLicenseplate(String licenseplate);
	Car findByYear(int year);
	Car findByModelnumber(String modelnumber);
	Car findByCity(String city);
	
}