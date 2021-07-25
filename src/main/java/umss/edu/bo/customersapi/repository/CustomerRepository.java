package umss.edu.bo.customersapi.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umss.edu.bo.customersapi.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

  List<Customer> findByName(String name);

  List<Customer> findByAge(Integer age);
}

