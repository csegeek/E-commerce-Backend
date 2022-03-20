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

import Ecommerce.ECommerce.backend.Dto.OrderReceive;
import Ecommerce.ECommerce.backend.Dto.OrderResponse;
import Ecommerce.ECommerce.backend.Dto.OrderUpdate;
import Ecommerce.ECommerce.backend.Dto.UpdateStatus;
import Ecommerce.ECommerce.backend.Exceptions.ResourceNotFoundException;
import Ecommerce.ECommerce.backend.Model.Order;
import Ecommerce.ECommerce.backend.Service.OrderService;

@RestController
@RequestMapping("/order")


public class OrderController {
    
    @Autowired
    private OrderService orderService;

@GetMapping
public List<OrderResponse> getorders(){
    return this.orderService.getOrders();
}

@GetMapping("{order_id}")
public ResponseEntity<OrderResponse> getById( @PathVariable Integer order_id) throws ResourceNotFoundException{
    return this.orderService.getOrderById(order_id);
}

@PostMapping
public ResponseEntity<String> addorder(@RequestBody OrderReceive orderreceive) throws Exception{

    Order order=this.orderService.addOrder(orderreceive);
    return ResponseEntity.ok("Order_id :"+ order.getId());

}

@PutMapping
public ResponseEntity<String> updateOrder(@RequestBody OrderUpdate orderupdate ) throws ResourceNotFoundException{
    this.orderService.updateOrder(orderupdate);
    return ResponseEntity.ok("Order Updated ....");
}

@PutMapping("/statusupdate")
public ResponseEntity<String> updatestatus(@RequestBody UpdateStatus updatestatus) throws ResourceNotFoundException{
    return this.orderService.updateStatus(updatestatus.getOrder_id(), updatestatus.getStatus());
}

@DeleteMapping("{order_id}")
public ResponseEntity<String> deleteorder(@PathVariable Integer order_id){
    this.orderService.deleteOrder(order_id);
    return ResponseEntity.ok("Order Deleted ...");
}
}
