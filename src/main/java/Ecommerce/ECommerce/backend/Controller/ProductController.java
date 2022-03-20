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

import Ecommerce.ECommerce.backend.Exceptions.ResourceNotFoundException;
import Ecommerce.ECommerce.backend.Model.Product;
import Ecommerce.ECommerce.backend.Service.ProductService;

@RestController
@RequestMapping("/product")

public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getProducts(){
        return this.productService.getProducts();
    }

    @GetMapping("{product_id}")
    public ResponseEntity<Product> getById( @PathVariable Integer product_id) throws ResourceNotFoundException{
        return this.productService.getProductById(product_id);
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product){
        return this.productService.addProduct(product);
    }

    @PutMapping
    public ResponseEntity<Product>updateProduct(@RequestBody Product product) throws ResourceNotFoundException{
        return this.productService.updateProduct(product);
    }

    @DeleteMapping("{product_id}")

    public ResponseEntity<String> deleteProduct( @PathVariable Integer product_id){
        this.productService.deleteProduct(product_id);
        return ResponseEntity.ok("Product Deleted Sucessfully");
    }


}
