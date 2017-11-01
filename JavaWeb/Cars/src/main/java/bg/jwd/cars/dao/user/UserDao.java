package bg.jwd.cars.dao.user;

import java.util.List;

import bg.jwd.cars.dto.user.UserRegisterDto;
import bg.jwd.cars.entity.user.AutoUser;

public interface UserDao {
	AutoUser getUser(String username);

	List<AutoUser> getUsers(String username, String status);
	
	String findUserUsername(long id);

	AutoUser findUserByUsername(String username);

	void registerUser(UserRegisterDto userRegisterDto);
}