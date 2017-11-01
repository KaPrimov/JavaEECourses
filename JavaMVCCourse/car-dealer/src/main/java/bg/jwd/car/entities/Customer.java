package bg.jwd.car.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMERS")
public class Customer
{
	private Long id;
	private String name;
	private Date birthDate;
	private Boolean isYoungDriver;
	
	public Customer()
	{
	}

	@Id
	@Column(name = "ID")
	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	@Column(name = "NAME")
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Column(name = "BIRTH_DATE")
	public Date getBirthDate()
	{
		return birthDate;
	}

	public void setBirthDate(Date birthDate)
	{
		this.birthDate = birthDate;
	}

	@Column(name = "IS_YOUNG_DRIVER")
	public Boolean getIsYoungDriver()
	{
		return isYoungDriver;
	}

	public void setIsYoungDriver(Boolean isYoungDriver)
	{
		this.isYoungDriver = isYoungDriver;
	}
}
