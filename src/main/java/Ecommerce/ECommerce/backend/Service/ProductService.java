package Ecommerce.ECommerce.backend.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import Ecommerce.ECommerce.backend.Exceptions.ResourceNotFoundException;
import Ecommerce.ECommerce.backend.Model.Product;

public interface ProductService {
    public  Product addProduct(Product product);
    
    public ResponseEntity<Product> updateProduct(Product  product) throws ResourceNotFoundException;

    public void deleteProduct(Integer id);
    
    public ResponseEntity<Product>  getProductById(Integer id) throws ResourceNotFoundException;

    public List<Product> getProducts();
} 
