package com.blz.orderservice.service;

import com.blz.orderservice.model.OrderBookModel;

import java.util.List;

public interface IOrderService {

    OrderBookModel placeOrder(Long cartId, Long addressId, String token);

    OrderBookModel cancelOrder(Long orderId, String token);

    List<OrderBookModel> getAllOrders(String token);

    List<OrderBookModel> getUserOrders(String token);

}
