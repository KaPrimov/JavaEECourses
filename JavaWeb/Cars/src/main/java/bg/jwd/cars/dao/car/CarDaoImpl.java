package bg.jwd.cars.dao.car;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import bg.jwd.cars.dto.car.CarHomeViewDto;
import bg.jwd.cars.entity.car.Car;

@Repository
public class CarDaoImpl implements CarDao
{
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<CarHomeViewDto> getAllCars() {
		
		String query = "SELECT c FROM Car c";
		TypedQuery<Car> typedCarQuery= entityManager.createQuery(query, Car.class);
		List<Car> carModels = typedCarQuery.getResultList(); 
		/*List<CarHomeViewDto> carDtos = DtoConverter.convert(cars, CarHomeViewDto.class);*/
/*		Query q = entityManager.createNativeQuery(query);
		List result = q.getResultList();
		System.out.println(result.size());*/
		return null;
	}
}
