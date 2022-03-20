package Ecommerce.ECommerce.backend.Dto;

import java.util.List;

import Ecommerce.ECommerce.backend.Model.Order;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class CustomerDao {
    private Integer id;
    private String Name;
    private String address;
    private String country;
    private List<Order> orders;


   public  CustomerDao(){

    }
}
