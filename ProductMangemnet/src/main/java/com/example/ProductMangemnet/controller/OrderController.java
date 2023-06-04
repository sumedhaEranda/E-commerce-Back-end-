package com.example.ProductMangemnet.controller;

import com.example.ProductMangemnet.dto.*;
import com.example.ProductMangemnet.entity.Customer;
import com.example.ProductMangemnet.entity.Order;
import com.example.ProductMangemnet.service.CustomerService;
import com.example.ProductMangemnet.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
@RestController
public class OrderController {


    @Autowired
    CustomerService customerService;
    @Autowired
    OrderService orderService;
//    @PostMapping("/AddUser")
//    public ResponseEntity<Customer> postBody(@RequestBody Customer userdt) {
//
//      Customer user=  userServices.SaveUserdata(userdt);
//     return ResponseEntity.ok(user);




//    @GetMapping("/users/{userId}/cart")
//    public ResponseEntity<List<CartItemDTO>>getUserCart(@PathVariable Long userId) {
//        Customer user = userRepo.findById(userId).get();
//
//        List<CartItemDTO> cartItems = new ArrayList<>();
//
//        for (Cart cart : user.getCarts()) {
//            cartItems.add(new CartItemDTO(cart.getProduct().getName(), cart.getQuantity()));
//        }
//
//        return ResponseEntity.ok(cartItems);
//    }
//
//    @PostMapping("/userCart/")
//    public ResponseEntity<Customer> SaveCartWithUser(@RequestBody SaveCartItem saveCartItem) {
//
//        Customer saveCartUser=userServices.addCartToUser(saveCartItem.getUserId(),saveCartItem.getProductId(),saveCartItem.getQuantity());
//        return ResponseEntity.ok(saveCartUser);
//    }


//    @GetMapping(value = "/getOrder/{orderId}")
//    public ResponseEntity<Order> getOrderDetails(@PathVariable int orderId) {
//
//        Order order = orderService.getOrderDetail(orderId);
//        return ResponseEntity.ok(order);
//    }


    @GetMapping(value = "/getOrder/{orderId}")
    public ResponseEntity<List<RespoceOrderDetails>> getOrderDetails(@PathVariable int orderId) {

        List<RespoceOrderDetails> orderDetail = orderService.getOrderDetail(orderId);
        return ResponseEntity.ok(orderDetail);
    }




    @PostMapping("/placeOrder")
    public ResponseEntity<ResponseOrderDTO> placeOrder(@RequestBody OrderDTO orderDTO) {

        ResponseOrderDTO responseOrderDTO = new ResponseOrderDTO();
        Customer customer = new Customer(orderDTO.getEmail(), orderDTO.getName(),orderDTO.getContactNo(),orderDTO.getCity(),orderDTO.getAddress());
        customerService.isCustomerPresent(customer);
        Order order = new Order(customer, orderDTO.getCartItems(),orderDTO.getTotalAmount());
        int orderId= orderService.saveOrder(order);
        responseOrderDTO.setOrderId(orderId);
        return ResponseEntity.ok(responseOrderDTO);
    }

    @GetMapping(value = "/getAllOrder")
    public List<GetInvoiceResponce> getOrdersWithCustomerDetails() {
        return orderService.getCustomersWithAddresses();
    }

    @GetMapping(value = "/getAllSalesOrderforCategory")
    public List<GetSalesOrder> getAllSalesOrdersforCategory() {
        return orderService.getAllSalesOrderforCategory();
    }

    @DeleteMapping(value = "/deleteOrder/{orderId}")
    public Integer deleyeorder(@PathVariable int orderId)
    {

        return orderService.deleteOrderByIdDetail(orderId);
    }
}
