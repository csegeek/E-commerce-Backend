package Ecommerce.ECommerce.backend.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import Ecommerce.ECommerce.backend.Dto.CustomerDao;
import Ecommerce.ECommerce.backend.Exceptions.ResourceNotFoundException;
import Ecommerce.ECommerce.backend.Model.Customer;

public interface CustomerService {
    public Customer AddCustomer(Customer customer);

    public ResponseEntity<Customer> UpdateCustomer(Customer customer) throws ResourceNotFoundException;
     
    public void DeleteCustomer(Integer id);

    public List<CustomerDao> getCustomer();

    public ResponseEntity<CustomerDao>  getCustomerbyId( Integer id) throws ResourceNotFoundException;

}
