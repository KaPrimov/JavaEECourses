package bg.jwd.cars.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bg.jwd.cars.dao.user.UserDao;
import bg.jwd.cars.entity.user.AutoUser;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public List<AutoUser> getUsers(String username, String status) {
		return userDao.getUsers(username, status);
	}
}