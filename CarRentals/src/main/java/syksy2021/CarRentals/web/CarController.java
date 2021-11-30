package syksy2021.CarRentals.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import syksy2021.CarRentals.domain.Car;
import syksy2021.CarRentals.domain.CarRepository;
import syksy2021.CarRentals.domain.ModelRepository;
/*import syksy2021.CarRentals.domain.TownRepository;*/

@Controller
public class CarController {
	@Autowired
	private CarRepository repository;
	
	@Autowired
	private ModelRepository drepository;
	
/*	@Autowired
	private TownRepository trepository;*/
	
	//Show all cars
	@RequestMapping (value = {"/index", "/", "/carlist"})
	public String carList(Model model) {
		model.addAttribute("cars", repository.findAll());
		return "carlist";
	}
	
	//RESTful service to get car by id
	@RequestMapping(value="/car/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Car> findCarRest(@PathVariable("id") Long carId) {
		return repository.findById(carId);
	}
	
	//Add a new car
	@RequestMapping(value = "/add")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String addCar(Model model) {
		model.addAttribute("car", new Car());
		model.addAttribute("models", drepository.findAll());
		/*model.addAttribute("towns", trepository.findAll());*/
		return "addcar";
	}
	
	//Save new car
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Validated @ModelAttribute("car") Car car, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			if (bindingResult.getFieldError().getField().equalsIgnoreCase("usdperhour")) {
				bindingResult.rejectValue("usdperhour", "err.usdperhour", "Check hourly rate format");
			} else {
				System.out.println("There was an error saving the data");
			}
			return "redirect:carlist";
		}
		repository.save(car);
		return "redirect:carlist";
	}
	
	//Delete car
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteCar(@PathVariable("id") Long carId, Model model) {
		repository.deleteById(carId);
		return "redirect:../carlist";
	}
	
	//Edit car
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String addCar(@PathVariable("id") Long carId, Model model) {
		model.addAttribute("car", repository.findById(carId));
		model.addAttribute("models", drepository.findAll());
		/*model.addAttribute("towns", trepository.findAll());*/
		return "editcar";
	}
 

}
