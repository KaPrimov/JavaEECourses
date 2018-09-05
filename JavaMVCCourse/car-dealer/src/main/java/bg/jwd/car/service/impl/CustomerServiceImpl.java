package bg.jwd.car.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bg.jwd.car.dao.CustomerDao;
import bg.jwd.car.dto.CustomerViewDto;
import bg.jwd.car.entities.Customer;
import bg.jwd.car.service.api.CustomerService;
import bg.jwd.car.utils.DtoConverter;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService
{
	@Autowired
	private CustomerDao customerDao;

	@Override
	public List<CustomerViewDto> findAllCustomers(String type)
	{
		if ("ascending".equals(type))
		{
			List<Customer> customerModels = customerDao.findAllCustomersOrderByBirthDateAsc();
			return DtoConverter.convert(customerModels, CustomerViewDto.class);
		} 
		else if ("descending".equals(type)) 
		{
			List<Customer> customerModels = customerDao.findAllCustomersOrderByBirthDateDesc();
			return DtoConverter.convert(customerModels, CustomerViewDto.class);			
		}
		else 
		{
			throw new IllegalArgumentException("The parameter is not specified.");
		}
	}

}
