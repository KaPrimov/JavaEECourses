package bg.jwd.cars.entity.user;

//@Entity
//@Table(name = "USER_AUTHORITY")
public class UserAuthority {

	private AutoUser user;
	private Authority authority;

	public AutoUser getUser() {
		return user;
	}

	public void setUser(AutoUser user) {
		this.user = user;
	}

	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}
}
