package syksy2021.CarRentals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import syksy2021.CarRentals.CarRentalsApplication;
import syksy2021.CarRentals.domain.Car;
import syksy2021.CarRentals.domain.CarRepository;
import syksy2021.CarRentals.domain.Model;
import syksy2021.CarRentals.domain.ModelRepository;
import syksy2021.CarRentals.domain.*;

@SpringBootApplication
public class CarRentalsApplication {
	private static final Logger log = LoggerFactory.getLogger(CarRentalsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CarRentalsApplication.class, args);
	}
	
	
	@Bean
	public CommandLineRunner carDemo(CarRepository srepository, ModelRepository drepository, /*TownRepository trepository,*/ UserRepository urepository) {
		return(args) -> {
			System.out.println("saving some cars");
			
/*			trepository.save(new Town("New York"));
			trepository.save(new Town("Los Angeles"));
			trepository.save(new Town("Chicago"));
			trepository.save(new Town("Houston"));
			trepository.save(new Town("Phoenix"));
			trepository.save(new Town("Philadelphia"));
			trepository.save(new Town("San Antonio"));
			trepository.save(new Town("San Diego"));
			trepository.save(new Town("Dallas"));
			trepository.save(new Town("San Jose")); */
			
			drepository.save(new Model("Alfa Romeo"));
			drepository.save(new Model("BMW"));
			drepository.save(new Model("Ford"));
			drepository.save(new Model("General Motors"));
			drepository.save(new Model("Honda"));
			drepository.save(new Model("Hyundai"));
			drepository.save(new Model("Mercedes Benz"));
			drepository.save(new Model("Nissan"));
			drepository.save(new Model("Renault"));
			drepository.save(new Model("Tesla"));
			drepository.save(new Model("Toyota"));
			drepository.save(new Model("Volkswagen"));
			
			/*
			srepository.save(new Car("BIG-999", "CLK320", 1980, "Helsinki", 49.0, drepository.findByName("Mercedes Benz").get(0), trepository.findByName("New York").get(0)));
			srepository.save(new Car("UZA-763", "X3", 1989, "Turku", 29.0, drepository.findByName("BMW").get(0), trepository.findByName("Houston").get(0)));
			*/
			srepository.save(new Car("BIG-999", "CLK320", 1980, "Helsinki", 49.0, true, drepository.findByName("Mercedes Benz").get(0)));
			srepository.save(new Car("UZA-763", "X3", 1989, "Turku", 29.0, true, drepository.findByName("BMW").get(0)));
			srepository.save(new Car("HKJ-778", "A4", 2006, "Vantaa", 31.0, false, drepository.findByName("General Motors").get(0)));
			srepository.save(new Car("XIJ-318", "Civic 4", 1999, "Espoo", 19.0, true, drepository.findByName("Honda").get(0)));
			srepository.save(new Car("WHT-698", "XV-1", 2008, "Vantaa", 18.0, true, drepository.findByName("Nissan").get(0)));
			srepository.save(new Car("YEH-712", "Qashqai", 2005, "Helsinki", 25.0, true, drepository.findByName("Nissan").get(0)));
			srepository.save(new Car("UGE-656", "CV-4", 2002, "Espoo", 18.0, false, drepository.findByName("Honda").get(0)));
			srepository.save(new Car("OJK-309", "W50", 2010, "Espoo", 21.0, true, drepository.findByName("Renault").get(0)));
			srepository.save(new Car("EEG-588", "EX40", 2009, "Helsinki", 32.0, false, drepository.findByName("Toyota").get(0)));
			srepository.save(new Car("QAB-399", "S-model", 2011, "Turku", 28.0, true, drepository.findByName("Tesla").get(0)));
			
			System.out.println("fetch all cars");
			for (Car car : srepository.findAll()) {
				System.out.println(car.toString());
				
			}
			
			// Create users: admin/admin user/user
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			User user3 = new User("guest", "$2a$10$O20XzuDhE49FbZKgFIN0O.gY1st4tRPyeB0MdwUPH1hiSvaTCPLQy", "GUEST");
			urepository.save(user1);
			urepository.save(user2);
			urepository.save(user3);
			
			log.info("fetch all cars");
			for (Car car : srepository.findAll()) {
				log.info(car.toString());
			}
		};
	}
	
	

}
