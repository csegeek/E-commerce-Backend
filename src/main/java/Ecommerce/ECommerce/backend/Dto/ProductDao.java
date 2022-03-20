package Ecommerce.ECommerce.backend.Dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class ProductDao {
  
    private Integer id;
    private @NotNull String product_title;
    private @NotNull double price;
    private @NotNull String product_description;

    public ProductDao(){
        
    }

}
