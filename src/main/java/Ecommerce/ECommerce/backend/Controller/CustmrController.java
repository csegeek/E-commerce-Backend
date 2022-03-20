package Ecommerce.ECommerce.backend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Ecommerce.ECommerce.backend.Dto.CustomerDao;
import Ecommerce.ECommerce.backend.Exceptions.ResourceNotFoundException;
import Ecommerce.ECommerce.backend.Model.Customer;
import Ecommerce.ECommerce.backend.Service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustmrController {
    @Autowired
    private CustomerService customerService;
   
    @GetMapping
    public List<CustomerDao>getAllcustomers(){
        return this.customerService.getCustomer();
    }

    @GetMapping("{cust_id}")
    public ResponseEntity<CustomerDao> getcustomer(@PathVariable Integer cust_id) throws ResourceNotFoundException{
        return this.customerService.getCustomerbyId(cust_id);
    }

    @PostMapping
    
    public Customer addCustomer(@RequestBody Customer customer ){
        return this.customerService.AddCustomer(customer);
    }

    @PutMapping 
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) throws ResourceNotFoundException
{
    return this.customerService.UpdateCustomer(customer);
}

@DeleteMapping("{cust_id}")
 public ResponseEntity<String> deleteCustomer(@PathVariable Integer cust_id){
     this.customerService.DeleteCustomer(cust_id);
     return ResponseEntity.ok("Customer deleted Sucessfully");
 }




}
