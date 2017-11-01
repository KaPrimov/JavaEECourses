package bg.jwd.car.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PARTS")
public class Part
{
	private Long id;
	private String name;
	private BigDecimal price;
	private Long quantity;
	private Supplier supplier;
	
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
	
	@Column(name = "PRICE")
	public BigDecimal getPrice()
	{
		return price;
	}
	public void setPrice(BigDecimal price)
	{
		this.price = price;
	}

	@Column(name = "QUANTITY")
	public Long getQuantity()
	{
		return quantity;
	}
	public void setQuantity(Long quantity)
	{
		this.quantity = quantity;
	}
	
	@ManyToOne
	@JoinColumn(name = "SUPPLIER_ID", referencedColumnName = "ID")
	public Supplier getSupplier()
	{
		return supplier;
	}
	public void setSupplier(Supplier supplier)
	{
		this.supplier = supplier;
	}	
}
