package com.blz.orderservice.repository;

import com.blz.orderservice.model.OrderBookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderServiceRepository extends JpaRepository<OrderBookModel, Long> {

    List<OrderBookModel> findByUserId(Long userId);

}
