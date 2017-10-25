package bg.softuni.web.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import bg.softuni.entity.UserModel;
import bg.softuni.service.UserServiceLocal;
import bg.softuni.web.utils.GeneralUtils;
import bg.softuni.web.utils.MessageUtils;

/**
 * The purpose of this class is to provide backend functionality of the login
 */
@ManagedBean(name = "loginBean")
@RequestScoped
public class LoginBean implements Serializable
{

	private static final long serialVersionUID = 1L;

	// beans.xml need to be added in WEB-INF in order CDI to work
	@Inject
	private HttpServletRequest request;

	private String username;
	private String password;

	// added
	@EJB
	UserServiceLocal userService;

	private static final String PAGE_CREATE_USER = "/page/createUser";
	private static final String SUCCESS_LOGIN_REDIRECT = "/page/listUsers?faces-redirect=true";
	private static final String LOGIN_PAGE_REDIRECT = "/page/login?faces-redirect=true";

	@PostConstruct
	public void init()
	{
		// TODO
	}

	/**
	 * Implement application login logic
	 * 
	 * @return
	 */
	public String login()
	{

		String cryptedPassword = GeneralUtils.encodeSha256Password(password);

		UserModel userModel = userService.loginUser(username, cryptedPassword);

		if (null == userModel)
		{
			MessageUtils.addErrorMessage("login.error.invalid.credentials");

			return "";
		} else
		{
			request.getSession().setAttribute("LOGGED_USER", userModel);
			return SUCCESS_LOGIN_REDIRECT;
		}
	}

	/**
	 * Implement application logout logic
	 * 
	 * @return
	 */
	public String logout()
	{
		request.getSession().invalidate();
		return LOGIN_PAGE_REDIRECT;
	}

	public String editAction()
	{
		return PAGE_CREATE_USER;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}
}