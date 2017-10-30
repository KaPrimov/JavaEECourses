package bg.jwd.cars.entity.car;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import bg.jwd.cars.entity.user.AutoUser;

@Entity
@Table(name = "CAR")
public class Car implements Serializable
{
	private static final long serialVersionUID = 1L;

	private long id;
	private String brand;
	private String model;
	private BigDecimal price;
	private AutoUser user;

	public Car()
	{
	}

	@Id
	@Column(name = "ID")
	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	@Column(name = "BRAND")
	public String getBrand()
	{
		return brand;
	}

	public void setBrand(String brand)
	{
		this.brand = brand;
	}

	@Column(name = "MODEL")
	public String getModel()
	{
		return model;
	}

	public void setModel(String model)
	{
		this.model = model;
	}

	@Column(name = "PRICE")
	public BigDecimal getPrice()
	{
		return price;
	}

	public void setPrice(BigDecimal price)
	{
		this.price = price;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USER")
	public AutoUser getUser()
	{
		return user;
	}

	public void setUser(AutoUser userId)
	{
		this.user = userId;
	}
}
