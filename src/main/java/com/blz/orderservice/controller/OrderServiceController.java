package com.blz.orderservice.controller;

import com.blz.orderservice.model.OrderBookModel;
import com.blz.orderservice.service.IOrderService;
import com.blz.orderservice.util.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/orderservie")
public class OrderServiceController {
    @Autowired
    IOrderService orderService;

    @PostMapping("/placeorder")
    public ResponseEntity<OrderResponse> placeOrder(@RequestParam Long cartId,
                                                    @RequestParam Long addressId,
                                                    @RequestHeader String token) {
        OrderBookModel order = orderService.placeOrder(cartId, addressId, token);
        OrderResponse orderResponse = new OrderResponse(200, "Successfull", order);
        return new ResponseEntity<OrderResponse>(orderResponse, HttpStatus.OK);
    }

    @DeleteMapping("/cancelorder/{orderId}")
    public ResponseEntity<OrderResponse> cancelOrder(@PathVariable Long orderId,
                                                     @RequestHeader String token) {
        OrderBookModel order = orderService.cancelOrder(orderId, token);
        OrderResponse orderResponse = new OrderResponse(200, "Successfull", order);
        return new ResponseEntity<OrderResponse>(orderResponse, HttpStatus.OK);
    }

    @GetMapping("/getallorders")
    public ResponseEntity<OrderResponse> getAllOrders(@RequestHeader String token) {
        List<OrderBookModel> order = orderService.getAllOrders(token);
        OrderResponse orderResponse = new OrderResponse(200, "Successfull", order);
        return new ResponseEntity<OrderResponse>(orderResponse, HttpStatus.OK);
    }

    @GetMapping("/fetchuserorders")
    public ResponseEntity<OrderResponse> getUserOrders(@RequestHeader String token) {
        List<OrderBookModel> order = orderService.getUserOrders(token);
        OrderResponse orderResponse = new OrderResponse(200, "Successfull", order);
        return new ResponseEntity<OrderResponse>(orderResponse, HttpStatus.OK);
    }

}
