package bg.jwd.cars.dto.car;

import java.math.BigDecimal;

public class AddCarDto
{
	private String model;
	private String brand;
	private BigDecimal price;
	
	public AddCarDto()
	{
	}
	
	public String getModel()
	{
		return model;
	}
	public void setModel(String model)
	{
		this.model = model;
	}
	public String getBrand()
	{
		return brand;
	}
	public void setBrand(String brand)
	{
		this.brand = brand;
	}
	public BigDecimal getPrice()
	{
		return price;
	}
	public void setPrice(BigDecimal price)
	{
		this.price = price;
	}
}
