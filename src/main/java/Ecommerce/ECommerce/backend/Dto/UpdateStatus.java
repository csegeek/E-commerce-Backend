package Ecommerce.ECommerce.backend.Dto;

import Ecommerce.ECommerce.backend.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateStatus {
    
    Integer order_id;
    OrderStatus status;

    public UpdateStatus(){
        
    }
}
