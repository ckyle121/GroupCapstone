package com.hackbright.capstone.services;

import com.hackbright.capstone.dtos.OrderDto;
import com.hackbright.capstone.entities.Order;
import com.hackbright.capstone.entities.Patron;
import com.hackbright.capstone.repositories.InstrumentRepository;
import com.hackbright.capstone.repositories.OrderRepository;
import com.hackbright.capstone.repositories.PatronRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private InstrumentRepository instrumentRepository;

    @Autowired
    private PatronRepository patronRepository;

    @Transactional
    public void addOrder(OrderDto orderDto, Long patronId) {
        Optional<Patron> patronOptional = patronRepository.findById(patronId);
        Order order = new Order(orderDto);
        patronOptional.ifPresent(order::setPatron);
        orderRepository.saveAndFlush(order);
        }

    public List<Order> getAllOrdersByPatronId(Long patronId) {
        Optional<Patron> patronOptional = patronRepository.findById(patronId);
        if (patronOptional.isPresent()) {
            List<OrderDto> orderList = orderRepository.getAllOrdersByPatronId(patronOptional.get());
            return orderList.stream().map(order -> new Order(order)).collect(Collectors.toList());
        }return Collections.emptyList();
    }
}
