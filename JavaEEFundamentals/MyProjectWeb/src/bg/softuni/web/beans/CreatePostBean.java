package bg.softuni.web.beans;

import java.util.Date;
import java.util.Iterator;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import bg.softuni.entity.PostModel;
import bg.softuni.entity.UserModel;
import bg.softuni.service.PostServiceLocal;

@ManagedBean(name = "createPostBean")
@ViewScoped
public class CreatePostBean
{
	private static final String LOGGED_USER = "LOGGED_USER";

	@Inject
	private HttpServletRequest request;

	@EJB
	private PostServiceLocal postService;

	private PostModel post;

	public CreatePostBean()
	{
	}

	@PostConstruct
	public void init()
	{
		this.post = new PostModel();
	}

	public String createAction()
	{

		if (!validate())
		{
			return null;
		}

		this.post.setDate(new Date());
		UserModel author = (UserModel) request.getSession().getAttribute(LOGGED_USER);
		this.post.setAuthor(author);

		this.postService.save(post);
		return "/page/listPosts";
	}

	public boolean hasErrors()
	{
		Iterator<FacesMessage> messages = FacesContext.getCurrentInstance().getMessages();
		for (; messages.hasNext();)
		{
			FacesMessage message = messages.next();
			if (message.getSeverity().compareTo(FacesMessage.SEVERITY_ERROR) == 0)
			{
				return true;
			}
		}

		return false;
	}

	public PostModel getPost()
	{
		return post;
	}

	public void setPost(PostModel post)
	{
		this.post = post;
	}

	private boolean validate()
	{
		System.out.println(this.post);
		if (this.post.getContent().length() <= 0 || this.post.getTitle().length() <= 0)
		{
			return false;
		}

		return true;
	}

}
