package Ecommerce.ECommerce.backend.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import Ecommerce.ECommerce.backend.Dto.OrderReceive;
import Ecommerce.ECommerce.backend.Dto.OrderResponse;
import Ecommerce.ECommerce.backend.Dto.OrderUpdate;
import Ecommerce.ECommerce.backend.Exceptions.ResourceNotFoundException;
import Ecommerce.ECommerce.backend.Model.Order;
import Ecommerce.ECommerce.backend.enums.OrderStatus;

public interface OrderService {
    public Order addOrder(OrderReceive orderreceive)throws Exception;

    public ResponseEntity<Order> updateOrder(OrderUpdate  orderupdate) throws ResourceNotFoundException;

    public ResponseEntity<OrderResponse>getOrderById(Integer id) throws ResourceNotFoundException;

    public List<OrderResponse> getOrders();

    public void deleteOrder(Integer id);

    public ResponseEntity<String> updateStatus(Integer id,OrderStatus status) throws ResourceNotFoundException ;


    }
    

