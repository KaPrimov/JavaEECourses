package bg.jwd.cars.controller.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bg.jwd.cars.constant.UrlConstants;
import bg.jwd.cars.dao.car.CarDao;
import bg.jwd.cars.dto.car.AddCarDto;

@Controller
public class CarController
{
	@Autowired
	private CarDao carDao;
	
	@RequestMapping(value = UrlConstants.CREATE_CAR_URL, method = RequestMethod.GET)
	public String getCarAdd(Model model) {
		model.addAttribute("carAddUrl", UrlConstants.CREATE_CAR_URL);
		return "car/createCar";
	}
	
	@RequestMapping(value = UrlConstants.CREATE_CAR_URL, method = RequestMethod.POST)
	public String getCarAdd(Model model, @ModelAttribute("addCarDto") AddCarDto addCarDto) {
		carDao.registerCar(addCarDto);
		
		model.addAttribute("carAddUrl", UrlConstants.CREATE_CAR_URL);
		return "car/createCar";
	}
}
