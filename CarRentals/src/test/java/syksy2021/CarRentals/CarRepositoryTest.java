package syksy2021.CarRentals;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import syksy2021.CarRentals.domain.Car;
import syksy2021.CarRentals.domain.CarRepository;
import syksy2021.CarRentals.domain.Model;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CarRepositoryTest {

	@Autowired
	private CarRepository repository;
	
	@Test
	public void findByLicenseplateShouldReturnLicenseplate() {
		List<Car> cars = repository.findByLicenseplate("BIG-999");
		
		assertThat(cars).hasSize(1);
		assertThat(cars.get(0).getLicenseplate()).isEqualTo("BIG-999");
	}
	
	@Test
	public void createNewCar() {
		Car car = new Car("BPO-798", "XZ88", 2003, "Oulu", 24.99, false, new Model("Ferrari"));
		repository.save(car);
		assertThat(car.getId()).isNotNull();
	}
	
	@Test
	void contextLoads() {
	}

}
