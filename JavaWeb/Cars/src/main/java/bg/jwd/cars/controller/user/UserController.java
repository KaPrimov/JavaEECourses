package bg.jwd.cars.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bg.jwd.cars.constant.UrlConstants;
import bg.jwd.cars.dto.user.UserSearch;
import bg.jwd.cars.service.user.UserService;
import bg.jwd.cars.utils.UserUtils;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = UrlConstants.USER_REGISTER_URL, method = RequestMethod.GET)
	public String getUsers(Model model, @ModelAttribute("UserSearch") UserSearch userSearch) {
		model.addAttribute("users", userService.getUsers(userSearch.getUsername(), userSearch.getStatus()));
		model.addAttribute("userRegisterUrl", UrlConstants.USER_REGISTER_URL);
		model.addAttribute("addUserUrl", UrlConstants.ADD_USER_URL);
		model.addAttribute("user", UserUtils.getUser());

		return "userRegister";
	}

}
