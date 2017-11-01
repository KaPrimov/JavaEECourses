package bg.jwd.cars.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bg.jwd.cars.constant.UrlConstants;
import bg.jwd.cars.dto.user.UserRegisterDto;
import bg.jwd.cars.service.user.UserService;

@Controller
public class RegisterController
{
	@Autowired
	private UserService userService;

	@RequestMapping(value = UrlConstants.USER_REGISTER_URL, method = RequestMethod.GET)
	public String getUserRegisterView(Model model)
	{
		model.addAttribute("userRegisterUrl", UrlConstants.USER_REGISTER_URL);
		return "user/register";
	}

	@RequestMapping(value = UrlConstants.USER_REGISTER_URL, method = RequestMethod.POST)
	public String registerUser(Model model, @ModelAttribute("UserRegister") UserRegisterDto userRegisterDto)
	{
		userService.registerUser(userRegisterDto);
		return "home";
	}
}
