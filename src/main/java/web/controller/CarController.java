package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class CarController {

	@GetMapping(value = "cars")
	public String printWelcome(@RequestParam Map<String,String> allRequestParams, ModelMap model) {
		CarService carService = new CarService();
		List<Car> cars = carService.getCars(Integer.valueOf(allRequestParams.getOrDefault("count", "5")));
		model.addAttribute("cars", cars);
		return "cars";
	}
	
}