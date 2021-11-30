package syksy2021.CarRentals.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Car {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String licenseplate;
	private String modelnumber;
	private int year;
	private String city;
	private double usdperhour;
	private boolean available;
	
	
	@ManyToOne
	@JoinColumn(name = "modelid")
	private Model model;
/*	@JoinColumn(name= "townid")
	private Town town; */
	
	public Car() {}
	
	public Car(String licenseplate, String modelnumber, int year, String city, double usdperhour, boolean available, Model model/*, Town town*/) {
		super();
		this.licenseplate = licenseplate;
		this.modelnumber = modelnumber;
		this.year = year;
		this.city = city;
		this.usdperhour = usdperhour;
		this.available = available;
		this.model = model;
		/*this.town = town; */
	}
	
	public Car(String licenseplate, String modelnumber, int year, String city, double usdperhour, Model model/*, Town town*/) {
		super();
		this.licenseplate = licenseplate;
		this.modelnumber = modelnumber;
		this.year = year;
		this.city = city;
		this.usdperhour = usdperhour;
		this.available = false;
		this.model = model;
		/*this.town = town; */
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getLicenseplate() {
		return licenseplate;
	}

	public void setLicenseplate(String licenseplate) {
		this.licenseplate = licenseplate;
	}

	public String getModelnumber() {
		return modelnumber;
	}

	public void setModelnumber(String modelnumber) {
		this.modelnumber = modelnumber;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getUsdperhour() {
		return usdperhour;
	}

	public void setUsdperhour(double usdperhour) {
		this.usdperhour = usdperhour;
	}
	
	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", licenseplate=" + licenseplate + ", modelnumber=" + modelnumber + ", year=" + year
				+ ", city=" + city + ", usdperhour=" + usdperhour + ", available=" + available + ", model=" + model
				+ "]";
	}
	
/*
	public Town getTown() {
		return town;
	}

	public void setTown(Town town) {
		this.town = town;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", licenseplate=" + licenseplate + ", modelnumber=" + modelnumber + ", year=" + year
				+ ", city=" + city + ", usdperhour=" + usdperhour + ", model=" + model + ", town=" + town + "]";
	}
	*/
	
	
	
}