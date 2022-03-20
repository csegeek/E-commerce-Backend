package Ecommerce.ECommerce.backend.Dto;

import java.sql.Date;

import Ecommerce.ECommerce.backend.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderResponse {
    
    private Integer id;
    private String customer;
    private  String country ;
    private String adress;
    private String product_title;
    private String Product_descroption;
    private Date date;
    private OrderStatus status;

    public OrderResponse(){

    }

}
