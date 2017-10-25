package bg.softuni.web.beans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import bg.softuni.dto.PostTableViewDto;
import bg.softuni.service.PostServiceLocal;

@ManagedBean(name = "showPostsBean")
@ViewScoped
public class ShowPostsBean
{
	@EJB
	PostServiceLocal postService;
	
	public ShowPostsBean()
	{
		// TODO Auto-generated constructor stub
	}
	
	public List<PostTableViewDto> getAllPosts()
	{
		return postService.getallPostForTable();
	}
	
	public String showPosts() {
		return "/page/listPosts";
	}
	
	public String showDetailsAction()
	{
		return "/page/detailsPost";
	}
}
