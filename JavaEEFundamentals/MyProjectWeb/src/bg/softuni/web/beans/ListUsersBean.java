package bg.softuni.web.beans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import bg.softuni.entity.UserModel;
import bg.softuni.service.UserServiceLocal;

@ManagedBean(name = "listUsersBean")
@ViewScoped
public class ListUsersBean
{

	@EJB
	UserServiceLocal userService;

	public String editAction()
	{
		return "/page/editUser";
	}

	public String createAction()
	{
		return "/page/createPost";
	}

	public List<UserModel> getAllUsers()
	{
		return userService.getAllUserForDisplay();
	}

}