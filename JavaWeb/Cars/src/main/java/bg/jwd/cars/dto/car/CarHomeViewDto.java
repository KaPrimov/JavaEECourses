package bg.jwd.cars.dto.car;

import java.math.BigDecimal;

public class CarHomeViewDto
{
	private String brand; 
	private String model;
	private BigDecimal price;
	private String userUsername;
	
	public CarHomeViewDto(String brand, String model, BigDecimal price, String userUsername)
	{
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.userUsername = userUsername;
	}

	public CarHomeViewDto()
	{
	}
	
	public String getBrand()
	{
		return brand;
	}

	public void setBrand(String brand)
	{
		this.brand = brand;
	}

	public String getModel()
	{
		return model;
	}

	public void setModel(String model)
	{
		this.model = model;
	}

	public BigDecimal getPrice()
	{
		return price;
	}

	public void setPrice(BigDecimal price)
	{
		this.price = price;
	}

	public String getUserUsername()
	{
		return userUsername;
	}

	public void setUserUsername(String userUsername)
	{
		this.userUsername = userUsername;
	}
}
