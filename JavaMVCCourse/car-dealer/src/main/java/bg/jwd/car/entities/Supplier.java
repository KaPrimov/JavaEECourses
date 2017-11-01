package bg.jwd.car.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SUPPLIERS")
public class Supplier
{
	private Long id;
	private String name;
	private Boolean isImporter;
	private Set<Part> parts;
		
	public Supplier()
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

	@Column(name = "NAME")
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
	@Column(name = "IS_IMPORTER")
	public Boolean getIsImporter()
	{
		return isImporter;
	}
	public void setIsImporter(Boolean isImporter)
	{
		this.isImporter = isImporter;
	}
	
	@OneToMany(mappedBy = "supplier")
	public Set<Part> getParts()
	{
		return parts;
	}

	public void setParts(Set<Part> parts)
	{
		this.parts = parts;
	}
}
