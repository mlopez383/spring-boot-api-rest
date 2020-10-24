package umss.edu.bo.customersapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import umss.edu.bo.customersapi.model.Customer;
import umss.edu.bo.customersapi.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {
  @Autowired
  private CustomerService customerService;

  // GET api/customers
  @GetMapping("/customers")
  public List<Customer> getCustomers() {
    return customerService.findAll();
  }

  // GET api/customer/{id}
  @GetMapping("/customer/{id}")
  public ResponseEntity<Customer> getCustomer(@PathVariable Long id) {
    Optional<Customer> customer = customerService.findById(id);
    if (customer.isPresent()) {
      return ResponseEntity.ok(customer.get());
    }
    return ResponseEntity.notFound().build();
  }

  // GET api/customers/?name={name}
  @GetMapping("/customers/")
  public List<Customer> getCustomerByName(@RequestParam(value = "name") String name) {
    return customerService.findByName(name);
  }

  // POST api/customer/{id}
  @PostMapping("/customer")
  public Customer createCustomer(@RequestBody Customer customer) {
    return customerService.save(customer);
  }

  // PUT api/customer/{id}
  @PutMapping("/customer")
  public Customer updateCustomer(@RequestBody Customer customer) {
    return customerService.update(customer);
  }

  // DELETE api/customer/{id}
  @DeleteMapping("/customer/{id}")
  public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
    return customerService.deleteById(id);
  }
}
