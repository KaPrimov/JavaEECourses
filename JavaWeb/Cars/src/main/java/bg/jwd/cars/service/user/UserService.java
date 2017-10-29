package bg.jwd.cars.service.user;

import java.util.List;

import bg.jwd.cars.entity.user.AutoUser;

public interface UserService {
	List<AutoUser> getUsers(String username, String status);
}
