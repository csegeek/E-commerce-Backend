package Ecommerce.ECommerce.backend.Service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import Ecommerce.ECommerce.backend.Exceptions.ResourceNotFoundException;
import Ecommerce.ECommerce.backend.Model.Product;
import Ecommerce.ECommerce.backend.Repository.ProductRepo;
import Ecommerce.ECommerce.backend.Service.ProductService;

@Service
public class ProductServiceImpl implements ProductService  {

    @Autowired
    private ProductRepo productRepo;
 
    @Override
    public Product addProduct(Product product) {
      
        return this.productRepo.save(product);
    }

    @Override
    public ResponseEntity<Product> updateProduct(Product product)  throws ResourceNotFoundException{
       Integer id=product.getId();
        this.productRepo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("product not found for this id :: " + id));
        
        return ResponseEntity.ok(this.productRepo.save(product));
    }

    @Override
    public void deleteProduct(Integer id) {
        this.productRepo.deleteById(id);
        
    }

    @Override
    public ResponseEntity<Product>getProductById(Integer id) throws ResourceNotFoundException {
         Product product=this.productRepo.findById(id)
         .orElseThrow(() -> new ResourceNotFoundException("product not found for this id :: " + id));
        return ResponseEntity.ok(product);
    }

    @Override
    public List<Product> getProducts() {
  
        return this.productRepo.findAll();
    }
    
}
