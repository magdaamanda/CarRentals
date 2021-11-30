package syksy2021.CarRentals.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Model {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long modelid;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "model")
	private List<Car> cars;
	
	public Model() {}
	
	public Model(String name) {
		super();
		this.name = name;
	}

	public Long getModelid() {
		return modelid;
	}

	public void setModelid(Long modelId) {
		this.modelid = modelId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	@Override
	public String toString() {
		return "Model [modelid=" + modelid + ", name=" + name + "]";
	}
	
	
}