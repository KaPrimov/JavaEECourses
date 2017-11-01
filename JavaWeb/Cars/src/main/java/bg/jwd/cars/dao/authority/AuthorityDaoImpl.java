package bg.jwd.cars.dao.authority;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import bg.jwd.cars.entity.user.Authority;

@Repository
public class AuthorityDaoImpl implements AuthorityDao
{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Authority findAuthority(String name)
	{
		String query = "SELECT a FROM Authority AS a WHERE a.authority = ?1";
		TypedQuery<Authority> authorityQuery = entityManager.createQuery(query, Authority.class);
		authorityQuery.setParameter(1, name);
		
		return authorityQuery.getSingleResult();
	}
	
}
