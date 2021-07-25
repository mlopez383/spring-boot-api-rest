package umss.edu.bo.customersapi.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import umss.edu.bo.customersapi.model.Customer;

@SpringBootTest
public class CustomerServiceTest {

  @Autowired
  private CustomerService customerService;

  @Test
  public void testFindAll() {
    List<Customer> customerList = customerService.findAll();
    assertThat(customerList).isNotNull();
    assertThat(customerList.size()).isEqualTo(2);
  }

  @Test
  public void testFindById() {
    Optional<Customer> customer = customerService.findById(1L);
    assertThat(customer.isPresent()).isEqualTo(true);
    assertThat(customer.get().getId()).isEqualTo(1L);
  }
}
