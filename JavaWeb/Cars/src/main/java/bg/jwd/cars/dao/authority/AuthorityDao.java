package bg.jwd.cars.dao.authority;

import bg.jwd.cars.entity.user.Authority;

public interface AuthorityDao
{
	Authority findAuthority(String name);
}
