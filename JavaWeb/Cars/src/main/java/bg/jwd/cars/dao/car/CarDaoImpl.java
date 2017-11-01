package bg.jwd.cars.dao.car;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import bg.jwd.cars.dao.user.UserDao;
import bg.jwd.cars.dto.car.AddCarDto;
import bg.jwd.cars.dto.car.CarHomeViewDto;
import bg.jwd.cars.entity.car.Car;
import bg.jwd.cars.entity.user.AutoUser;
import bg.jwd.cars.security.User;
import bg.jwd.cars.utils.DtoConverter;
import bg.jwd.cars.utils.UserUtils;

@Repository
public class CarDaoImpl implements CarDao
{
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public List<CarHomeViewDto> getAllCars() {
		
		String query = "SELECT * FROM CAR";
		Query typedCarQuery= entityManager.createNativeQuery(query);
		List<Object[]> carModels = typedCarQuery.getResultList(); 
		List<CarHomeViewDto> carDtos = new ArrayList<>();
		for (Object[] carObject : carModels)
		{
			
			CarHomeViewDto carHomeViewDto = new CarHomeViewDto(carObject[1].toString(), 
					carObject[2].toString(), 
					new BigDecimal(carObject[3].toString()), 
					userDao.findUserUsername(Long.parseLong(carObject[4].toString())));
			carDtos.add(carHomeViewDto);
		}
		return carDtos;
	}

	@Override
	@Transactional
	public void registerCar(AddCarDto addCarDto)
	{		
		Car car = DtoConverter.convert(addCarDto, Car.class);
		User user = UserUtils.getUser();
		AutoUser autoUser = userDao.findUserByUsername(user.getUsername());
		car.setUser(BigDecimal.valueOf(autoUser.getId()));
		entityManager.persist(car);
	}
}
