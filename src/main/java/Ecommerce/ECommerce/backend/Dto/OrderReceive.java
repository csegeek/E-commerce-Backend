package Ecommerce.ECommerce.backend.Dto;

import java.sql.Date;

import Ecommerce.ECommerce.backend.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class OrderReceive {

    Integer product_id;
    Integer customer_id;
    Date date;
    OrderStatus status;

    public OrderReceive(){
        
    }
    
}
