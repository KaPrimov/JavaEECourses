package bg.softuni.dto;

import java.util.Date;

import bg.softuni.entity.base.BaseDomainObject;

public class PostTableViewDto extends BaseDomainObject
{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String title;
	private Date date;
	private String authorFullName;
	
	public PostTableViewDto()
	{
		super();
	}

	public PostTableViewDto(Long id, String title, Date date, String authorFullName)
	{
		super();
		this.id = id;
		this.title = title;
		this.date = date;
		this.authorFullName = authorFullName;
	}
	
	public Long getId()
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}	
	public Date getDate()
	{
		return date;
	}
	public void setDate(Date date)
	{
		this.date = date;
	}
	public String getAuthorFullName()
	{
		return authorFullName;
	}
	public void setAuthorFullName(String author)
	{
		this.authorFullName = author;
	}
	
	
}
