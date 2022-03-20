package Ecommerce.ECommerce.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Ecommerce.ECommerce.backend.Model.Order;

public interface OrderRepo extends JpaRepository<Order ,Integer> {
    
}
