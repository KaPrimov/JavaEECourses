package bg.softuni.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import bg.softuni.entity.base.BaseDomainObject;

@Entity
@Table(name = "users")
public class UserModel extends BaseDomainObject
{

	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private long postsCount;
	private List<PostModel> posts;

	public UserModel()
	{
	}

	public UserModel(Long id, String username, String password, String first, String last, String email)
	{
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = first;
		this.lastName = last;
		this.email = email;
	}
	
	public UserModel(Long id, String username, String password, String first, String last, String email, long postsCount)
	{
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = first;
		this.lastName = last;
		this.email = email;
		this.postsCount = postsCount;
	}

	@Column(name = "username", length = 45, nullable = false)
	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	@Column(name = "password", length = 200, nullable = false)
	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	@Column(name = "first_name", length = 45, nullable = true)
	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	@Column(name = "last_name", length = 45, nullable = true)
	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	@Column(name = "email", length = 45, nullable = true)
	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "author", fetch = FetchType.LAZY)
	public List<PostModel> getPosts()
	{
		return posts;
	}

	public void setPosts(List<PostModel> posts)
	{
		this.posts = posts;
	}
	
	@Transient
	public long getPostsCount()
	{
		return postsCount;
	}

	public void setPostsCount(long postsCount)
	{
		this.postsCount = postsCount;
	}
	
	@Transient
	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}

	@Override
	public int hashCode()
	{
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object)
	{
		if (!(object instanceof UserModel))
		{
			return false;
		}
		UserModel other = (UserModel) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
		{
			return false;
		}
		return true;
	}

	@Override
	public String toString()
	{
		return "Users[ id=" + id + " ]";
	}
}