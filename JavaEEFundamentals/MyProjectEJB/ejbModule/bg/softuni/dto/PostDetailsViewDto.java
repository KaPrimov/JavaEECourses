package bg.softuni.dto;

public class PostDetailsViewDto extends PostTableViewDto
{
	private static final long serialVersionUID = 1L;

	private String content;

	public String getContent()
	{
		return content;
	}

	public void setContent(String details)
	{
		this.content = details;
	}
}
