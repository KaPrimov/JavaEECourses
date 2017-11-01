package bg.jwd.car.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SALES")
public class Sale
{
	private Long id;
	private BigDecimal discount;
	private Car car;
	private Customer customer;

	public Sale()
	{
		super();
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
	
	@Column(name = "DISCOUNT")
	public BigDecimal getDiscount()
	{
		return discount;
	}
	public void setDiscount(BigDecimal discount)
	{
		this.discount = discount;
	}
	
	@OneToOne
	@JoinColumn(name = "CAR_ID", referencedColumnName = "ID")
	public Car getCar()
	{
		return car;
	}
	public void setCar(Car car)
	{
		this.car = car;
	}
	
	@OneToOne
	@JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "ID")
	public Customer getCustomer()
	{
		return customer;
	}
	public void setCustomer(Customer customer)
	{
		this.customer = customer;
	}	
}
