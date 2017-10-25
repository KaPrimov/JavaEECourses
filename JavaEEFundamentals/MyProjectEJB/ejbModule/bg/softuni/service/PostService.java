package bg.softuni.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import bg.softuni.dto.PostDetailsViewDto;
import bg.softuni.dto.PostTableViewDto;
import bg.softuni.entity.PostModel;
import bg.softuni.utils.DTOConvertUtil;

/**
 * Session Bean implementation class PostService
 */
@Stateless
@LocalBean
public class PostService implements PostServiceLocal {
	
	@PersistenceContext
	protected EntityManager entityManager;

   
    public PostService() {
        super();
    }


	@Override
	public List<PostTableViewDto> getallPostForTable()
	{
		String query = "SELECT model FROM PostModel model ORDER BY model.id ASC";
		TypedQuery<PostModel> q = this.entityManager.createQuery(query, PostModel.class);
		List<PostTableViewDto> postsView = new ArrayList<>();
		for (PostModel postModel : q.getResultList())
		{
			postsView.add(DTOConvertUtil.convert(postModel, PostTableViewDto.class));
		}
		return postsView;
	}


	@Override
	public PostDetailsViewDto findById(Long id)
	{
		try
		{
			PostModel instance = this.entityManager.find(PostModel.class, id);
			
			return DTOConvertUtil.convert(instance, PostDetailsViewDto.class);
		} catch (RuntimeException re)
		{
			throw re;
		}
	}


	@Override
	public PostModel save(PostModel post)
	{
		this.entityManager.persist(post);
		return post;
		
	}
}
