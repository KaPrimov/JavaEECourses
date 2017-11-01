package bg.jwd.car.dto;

import java.util.Date;

public class CustomerViewDto
{
	private String name;
	private Date birthDate;
	private Boolean isYoungDriver;
	
	public CustomerViewDto()
	{
		super();
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Date getBirthDate()
	{
		return birthDate;
	}

	public void setBirthDate(Date birthDate)
	{
		this.birthDate = birthDate;
	}

	public Boolean getIsYoungDriver()
	{
		return isYoungDriver;
	}

	public void setIsYoungDriver(Boolean isYoungDriver)
	{
		this.isYoungDriver = isYoungDriver;
	}

	@Override
	public String toString()
	{
		return name + ": Birth Date= " + birthDate + "; Young Driver=" + isYoungDriver + "]";
	}	
	
	
}
