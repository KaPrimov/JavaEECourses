package bg.jwd.cars.dao.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import bg.jwd.cars.constant.NamingConstants;
import bg.jwd.cars.dao.authority.AuthorityDao;
import bg.jwd.cars.dto.user.UserRegisterDto;
import bg.jwd.cars.entity.user.Authority;
import bg.jwd.cars.entity.user.AutoUser;
import bg.jwd.cars.security.User;
import bg.jwd.cars.utils.DtoConverter;
import bg.jwd.cars.utils.UserUtils;

@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager entityManager;
		
	@Autowired
	private AuthorityDao authorityDao;
	
	@Override
	public AutoUser getUser(String username) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<AutoUser> criteriaQuery = criteriaBuilder.createQuery(AutoUser.class);
		Root<AutoUser> from = criteriaQuery.from(AutoUser.class);

		criteriaQuery.where(from.get("username").in(username));

		criteriaQuery.select(from);
		TypedQuery<AutoUser> query = entityManager.createQuery(criteriaQuery);
		List<AutoUser> users = query.getResultList();

		return users != null ? users.get(0) : null;
	}

	@Override
	public List<AutoUser> getUsers(String username, String status) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<AutoUser> criteriaQuery = criteriaBuilder.createQuery(AutoUser.class);
		Root<AutoUser> from = criteriaQuery.from(AutoUser.class);

		Predicate predicate1 = criteriaBuilder.and();
		Predicate predicate2 = criteriaBuilder.and();
		if (status != null && !status.isEmpty()) {
			predicate1 = from.get("status").in(status);
		}
		if (username != null && !username.isEmpty()) {
			predicate2 = from.get("username").in(username);
		}

		criteriaQuery.where(predicate1, predicate2);

		criteriaQuery.select(from);
		TypedQuery<AutoUser> query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}

	@Override
	public String findUserUsername(long id)
	{
		String usernameQuery = "SELECT au.username FROM AutoUser AS au WHERE au.id = ?1";
		TypedQuery<String> query= entityManager.createQuery(usernameQuery, String.class);
		query.setParameter(1, id);
		String username = query.getSingleResult();
		
		return username; 
	}

	@Override
	public AutoUser findUserByUsername(String username)
	{
		String userQuery = "SELECT au FROM AutoUser AS au WHERE au.username = ?1";
		TypedQuery<AutoUser> query= entityManager.createQuery(userQuery, AutoUser.class);
		query.setParameter(1, username);
		return query.getSingleResult();
	}

	@Override
	@Transactional
	public void registerUser(UserRegisterDto userRegisterDto)
	{
		AutoUser autoUser = DtoConverter.convert(userRegisterDto, AutoUser.class);
		List<Authority> authorities = new ArrayList<>();
		authorities.add(authorityDao.findAuthority(NamingConstants.USER_AUTHORITY));
		autoUser.setAuthorities(authorities);
		User user = UserUtils.getUser();
		AutoUser autoUserCreator = this.findUserByUsername(user.getUsername());
		autoUser.setPassword(UserUtils.encodeMd5(userRegisterDto.getPassword()));
		autoUser.setCreatedBy(autoUserCreator.getId());
		autoUser.setId(40);
		this.entityManager.persist(autoUser);		
	}

}