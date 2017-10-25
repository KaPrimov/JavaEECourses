package bg.softuni.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import bg.softuni.entity.UserModel;

/**
 * Session Bean implementation class UserService
 */
@Stateless
@LocalBean
public class UserService implements UserServiceLocal
{

	@PersistenceContext
	protected EntityManager entityManager;

	public UserService()
	{
		super();
	}

	@Override
	public List<UserModel> findAllUsers()
	{
		String query = "SELECT model FROM UserModel model ORDER BY upper(model.username) ASC";
		TypedQuery<UserModel> q = entityManager.createQuery(query, UserModel.class);

		return q.getResultList();
	}

	@Override
	public UserModel save(UserModel entity)
	{
		this.entityManager.persist(entity);
		return entity;
	}

	@Override
	public UserModel update(UserModel entity)
	{
		this.entityManager.merge(entity);
		this.entityManager.flush();
		return entity;
	}

	@Override
	public void delete(UserModel entity)
	{
		this.entityManager.remove(entity);
	}

	@Override
	public UserModel findById(Long id)
	{
		try
		{
			UserModel instance = this.entityManager.find(UserModel.class, id);
			return instance;
		} catch (RuntimeException re)
		{
			throw re;
		}
	}

	@Override
	public UserModel loginUser(String aUsername, String aPassword)
	{
		StringBuffer query = new StringBuffer(
				"SELECT model FROM UserModel model WHERE model.username = :username AND model.password = :password");

		Query q = this.entityManager.createQuery(query.toString());
		q.setParameter("username", aUsername);
		q.setParameter("password", aPassword);

		try
		{
			return (UserModel) q.getSingleResult();
		} catch (NoResultException nre)
		{
			// the user doesn't exist
			return null;
		}
	}

	@Override
	public UserModel checkUserExists(String username, Long id)
	{
		StringBuffer query = new StringBuffer(
				"SELECT model FROM UserModel model WHERE upper(model.username) = upper(:username)");

		if (id != null)
		{
			query.append(" and model.id <> :user_id");
		}

		Query q = this.entityManager.createQuery(query.toString());
		q.setParameter("username", username);
		
		if (id != null) 
		{
			q.setParameter("user_id", id);
		}
		
		try
		{
			return (UserModel) q.getSingleResult();
		} catch (NoResultException nre)
		{
			// the user doesn't exist
			return null;
		}
	}

	@Override
	public List<UserModel> getAllUserForDisplay()
	{
		String query = "SELECT new UserModel(model.id, model.username, model.password, model.firstName, model.lastName, model.email, count(postModel))"
				+ " FROM UserModel AS model LEFT JOIN model.posts AS postModel"
				+ " GROUP BY model.id"
				+ " ORDER BY upper(model.username) ASC";
		TypedQuery<UserModel> q = this.entityManager.createQuery(query, UserModel.class);

		return q.getResultList();
	}
}