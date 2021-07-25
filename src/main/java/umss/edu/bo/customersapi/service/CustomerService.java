package umss.edu.bo.customersapi.service;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import umss.edu.bo.customersapi.model.Customer;
import umss.edu.bo.customersapi.repository.CustomerRepository;

@Service
public class CustomerService {

  private CustomerRepository customerRepository;
  private Logger logger = LoggerFactory.getLogger(CustomerService.class);

  public CustomerService(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public List<Customer> findAll() {
    logger.info("Request to get Customers");
    return customerRepository.findAll();
  }

  public Optional<Customer> findById(Long id) {
    logger.info("Request to get Customer by Id : {}", id);
    Optional<Customer> customer = customerRepository.findById(id);
    return customer;
  }

  public List<Customer> findByName(String name) {
    return customerRepository.findByName(name);
  }

  public List<Customer> findByAge(Integer age) {
    return customerRepository.findByAge(age);
  }

  public Customer save(Customer customer) {
    return customerRepository.save(customer);
  }

  public Customer update(Customer customer) {
    return customerRepository.save(customer);
  }

  public ResponseEntity<Void> deleteById(Long id) {
    customerRepository.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
