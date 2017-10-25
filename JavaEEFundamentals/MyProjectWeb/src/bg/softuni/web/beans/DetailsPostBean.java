package bg.softuni.web.beans;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import bg.softuni.dto.PostDetailsViewDto;
import bg.softuni.service.PostServiceLocal;

@ManagedBean(name = "detailsPostBean")
@ViewScoped
public class DetailsPostBean
{
	@Inject
	HttpServletRequest request;

	@EJB
	PostServiceLocal postService;

	private PostDetailsViewDto post;
	
	@PostConstruct
	public void init()
	{
		String idParam = request.getParameter("id");

		if (StringUtils.isNotBlank(idParam) && StringUtils.isNumeric(idParam))
		{
			Long id = Long.parseLong(idParam);
			this.post = this.postService.findById(id);
		}
	}

	public PostDetailsViewDto getPost()
	{
		return post;
	}

	public void setPost(PostDetailsViewDto post)
	{
		this.post = post;
	}
	
	
}
