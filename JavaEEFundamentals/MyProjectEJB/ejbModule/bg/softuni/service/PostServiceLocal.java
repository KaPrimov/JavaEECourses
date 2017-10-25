package bg.softuni.service;

import java.util.List;


import javax.ejb.Local;

import bg.softuni.dto.PostDetailsViewDto;
import bg.softuni.dto.PostTableViewDto;
import bg.softuni.entity.PostModel;

@Local
public interface PostServiceLocal {
	
	List<PostTableViewDto> getallPostForTable();
	
	PostDetailsViewDto findById(Long id);
	
	PostModel save(PostModel post);
}
