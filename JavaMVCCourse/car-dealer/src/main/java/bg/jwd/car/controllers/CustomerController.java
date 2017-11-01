package bg.jwd.car.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import bg.jwd.car.dto.CustomerViewDto;
import bg.jwd.car.service.api.CustomerService;

@Controller
public class CustomerController
{
	@Autowired
	private CustomerService customerService;

	
	@GetMapping("/customers/all/{type}")
	@ResponseStatus(HttpStatus.OK)
	public ModelAndView getCustomers(@PathVariable("type") String type) {
		List<CustomerViewDto> viewDtos = this.customerService.findAllCustomers(type);
		ModelAndView mav = new ModelAndView("/list");
		mav.addObject("customers", viewDtos);
		return mav;
	}
}
