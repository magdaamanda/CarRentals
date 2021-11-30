package syksy2021.CarRentals.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ModelRepository extends CrudRepository<Model, Long> {
	
	List<Model> findByName(String name);
	
}