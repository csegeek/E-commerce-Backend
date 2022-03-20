package Ecommerce.ECommerce.backend.Service.Implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import Ecommerce.ECommerce.backend.Dto.OrderReceive;
import Ecommerce.ECommerce.backend.Dto.OrderResponse;
import Ecommerce.ECommerce.backend.Dto.OrderUpdate;
import Ecommerce.ECommerce.backend.Exceptions.ResourceNotFoundException;
import Ecommerce.ECommerce.backend.Model.Order;
import Ecommerce.ECommerce.backend.Repository.CustomerRepo;
import Ecommerce.ECommerce.backend.Repository.OrderRepo;
import Ecommerce.ECommerce.backend.Repository.ProductRepo;
import Ecommerce.ECommerce.backend.Service.OrderService;
import Ecommerce.ECommerce.backend.enums.OrderStatus;

@Service
public class OrderServiceImpl implements OrderService {

   @Autowired
   private OrderRepo orderRepo;

   @Autowired
   private CustomerRepo customerRepo;
    
   @Autowired
   private ProductRepo productRepo;

    @Override
    public Order addOrder(OrderReceive orderreceive) throws Exception {
       
        if(orderreceive.getStatus()!=OrderStatus.Completed && orderreceive.getStatus()!=OrderStatus.Prepared &&
        orderreceive.getStatus()!=OrderStatus.Delivered) throw new Exception ("Wrong status");
        Order order=new Order();
        order.setCustomer(this.customerRepo.getById(orderreceive.getCustomer_id()));
        order.setProduct(this.productRepo.getById(orderreceive.getProduct_id()));
        order.setDate(orderreceive.getDate());
        order.setStatus(orderreceive.getStatus());
        return  this.orderRepo.save(order);
        
    }

    @Override
    public ResponseEntity<Order> updateOrder(OrderUpdate orderupdate) throws ResourceNotFoundException {
         Integer id=orderupdate.getOrder_id();
        Order order=this.orderRepo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("order not found for this id :: " + id));
        order.setCustomer(this.customerRepo.getById(orderupdate.getCustomer_id()));
        order.setProduct(this.productRepo.getById(orderupdate.getProduct_id()));
        order.setDate(orderupdate.getDate());
        order.setStatus(orderupdate.getStatus());

        return ResponseEntity.ok(this.orderRepo.save(order) );
    }

    @Override
    public ResponseEntity<OrderResponse> getOrderById(Integer id) throws ResourceNotFoundException  {
      
        Order order=this.orderRepo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("order not found for this id :: " + id));
        OrderResponse orderresponse=new OrderResponse(
            order.getId(),order.getCustomer().getName(),order.getCustomer().getCountry(),order.getCustomer().getAddress()
            ,order.getProduct().getProduct_title(),order.getProduct().getProduct_description(),
            order.getDate(),order.getStatus()
        ) ;

        return ResponseEntity.ok(orderresponse);
    }

    @Override
    public List<OrderResponse> getOrders() {
       List<Order> temp= this.orderRepo.findAll();
       List<OrderResponse> response=new ArrayList<>();
       for(Order order:temp ){
        OrderResponse orderresponse=new OrderResponse(
            order.getId(),order.getCustomer().getName(),order.getCustomer().getCountry(),order.getCustomer().getAddress()
            ,order.getProduct().getProduct_title(),order.getProduct().getProduct_description(),
            order.getDate(),order.getStatus()
        ) ;
        response.add(orderresponse);
           
       }
       return response;
    }

    @Override
    public void deleteOrder(Integer id) {

         this.orderRepo.deleteById(id);
        
    }

    @Override
    public ResponseEntity<String> updateStatus(Integer id, OrderStatus status)  throws ResourceNotFoundException {
       Order order=this.orderRepo.findById(id)
       .orElseThrow(() -> new ResourceNotFoundException("order not found for this id :: " + id));
       order.setStatus(status);
        this.orderRepo.save(order);
        return ResponseEntity.ok("updated Status : "+ this.orderRepo.getById(id).getStatus());
    }
    
}
