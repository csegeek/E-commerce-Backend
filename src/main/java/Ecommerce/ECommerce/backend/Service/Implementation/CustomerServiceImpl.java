package Ecommerce.ECommerce.backend.Service.Implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import Ecommerce.ECommerce.backend.Dto.CustomerDao;
import Ecommerce.ECommerce.backend.Exceptions.ResourceNotFoundException;
import Ecommerce.ECommerce.backend.Model.Customer;
import Ecommerce.ECommerce.backend.Repository.CustomerRepo;
import Ecommerce.ECommerce.backend.Service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepo customerRepo;
    


    @Override
    public Customer AddCustomer(Customer customer) {
     return   this.customerRepo.save(customer);
        
    }

    @Override
    public ResponseEntity<Customer> UpdateCustomer(Customer customer) throws ResourceNotFoundException{
            Integer id=customer.getCustomer_id();
        this.customerRepo.findById(id)
              .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + id));
          return ResponseEntity.ok (this.customerRepo.save(customer));
    }

    @Override
    public void DeleteCustomer(Integer id) {
        
         this.customerRepo.deleteById(id);
    }

    @Override
    public List<CustomerDao> getCustomer() {
        
        List<CustomerDao> temp= new ArrayList<>();
        
        for(Customer C:this.customerRepo.findAll()){
            CustomerDao TempDao=new CustomerDao();
            TempDao.setId(C.getCustomer_id());
            TempDao.setName(C.getName());
            TempDao.setAddress(C.getAddress());
            TempDao.setCountry(C.getCountry());
            TempDao.setOrders(C.getOrders());
            
            temp.add(TempDao);
        }
        return temp;
    }

    @Override
    public ResponseEntity<CustomerDao> getCustomerbyId(Integer id)  throws ResourceNotFoundException  {
           
        Customer C =this.customerRepo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + id));

        CustomerDao customerdao=new CustomerDao(C.getCustomer_id(),C.getName(),C.getAddress(),C.getCountry(),C.getOrders());
        return ResponseEntity.ok(customerdao);
    }
    
}
