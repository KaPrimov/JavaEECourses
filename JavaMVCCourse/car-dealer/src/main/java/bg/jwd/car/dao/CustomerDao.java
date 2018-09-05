package bg.jwd.car.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import bg.jwd.car.entities.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Long>
{
	@Query("SELECT c FROM Customer c "
			+ "ORDER BY c.birthDate DESC, c.isYoungDriver ASC")
	List<Customer> findAllCustomersOrderByBirthDateDesc();
	
	@Query("SELECT c FROM Customer c "
			+ "ORDER BY c.birthDate ASC, c.isYoungDriver ASC")
	List<Customer> findAllCustomersOrderByBirthDateAsc();
}
