package bg.jwd.car.service.api;

import java.util.List;

import bg.jwd.car.dto.CustomerViewDto;

public interface CustomerService
{
    List<CustomerViewDto> findAllCustomers(String type);
}
