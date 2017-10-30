package bg.jwd.cars.dao.car;

import java.util.List;

import bg.jwd.cars.dto.car.CarHomeViewDto;

public interface CarDao
{
	List<CarHomeViewDto> getAllCars();
}
