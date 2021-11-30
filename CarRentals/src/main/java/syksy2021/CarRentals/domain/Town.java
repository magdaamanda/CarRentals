/*package syksy2021.CarRentals.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Town {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long townid;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "town")
	private List<Car> cars;
	
	public Town() {}
	
	public Town(String name) {
		super();
		this.name = name;
	}

	public Long getTownid() {
		return townid;
	}

	public void setTownid(Long townId) {
		this.townid = townId;
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
		return "Town [townid=" + townid + ", name=" + name + "]";
	}
	
	
}*/