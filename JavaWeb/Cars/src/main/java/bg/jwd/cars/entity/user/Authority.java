package bg.jwd.cars.entity.user;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "NM_AUTHORITY")
public class Authority
{

	private long id;

	private String authority;
	
	private Set<AutoUser> users;
	
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

	@Column(name = "AUTHORITY")
	public String getAuthority()
	{
		return authority;
	}

	public void setAuthority(String authority)
	{
		this.authority = authority;
	}
	
	@ManyToMany(mappedBy = "authorities")
	public Set<AutoUser> getUsers()
	{
		return users;
	}

	public void setUsers(Set<AutoUser> users)
	{
		this.users = users;
	}
}
