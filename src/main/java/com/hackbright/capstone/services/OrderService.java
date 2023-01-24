package com.hackbright.capstone.services;

import com.hackbright.capstone.dtos.OrderDto;
import com.hackbright.capstone.entities.Order;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public interface OrderService {

    @Transactional
    void addOrder(OrderDto orderdto, Long patronId);

    List<Order> getAllOrdersByPatronId(Long patronId);

}
