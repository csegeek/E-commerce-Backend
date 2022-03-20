package Ecommerce.ECommerce.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Ecommerce.ECommerce.backend.Model.Customer;

@Repository

public interface CustomerRepo extends JpaRepository<Customer ,Integer> {
    
}
