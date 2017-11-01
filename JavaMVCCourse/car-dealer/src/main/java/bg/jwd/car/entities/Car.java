package bg.jwd.car.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CARS")
public class Car
{
	private Long id;
	private String make;
	private String model;
	private Long kilometers;
	private Set<Part> parts;
		
	public Car() {	}
	
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
	
	@Column(name = "MAKE")
	public String getMake()
	{
		return make;
	}
	public void setMake(String make)
	{
		this.make = make;
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
	
	@Column(name = "KILOMETERS")
	public Long getKilometers()
	{
		return kilometers;
	}
	public void setKilometers(Long kilometers)
	{
		this.kilometers = kilometers;
	}
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "PARTS_CARS", 
		joinColumns = @JoinColumn(name = "CAR_ID", referencedColumnName = "ID"), 
		inverseJoinColumns = @JoinColumn(name = "PART_ID", referencedColumnName = "ID"))
	public Set<Part> getParts()
	{
		return parts;
	}

	public void setParts(Set<Part> parts)
	{
		this.parts = parts;
	}
}
