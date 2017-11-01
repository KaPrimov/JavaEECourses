package bg.jwd.cars.controller.home;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bg.jwd.cars.dao.car.CarDao;
import bg.jwd.cars.dto.car.CarHomeViewDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
		
	@Autowired
	private CarDao carDao;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		List<CarHomeViewDto> carDtos = carDao.getAllCars();
		model.addAttribute("cars", carDtos);
		return "home";
	}
	
}
