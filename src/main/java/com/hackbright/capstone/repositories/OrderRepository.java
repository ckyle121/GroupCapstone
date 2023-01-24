package com.hackbright.capstone.repositories;

import com.hackbright.capstone.dtos.OrderDto;
import com.hackbright.capstone.entities.Order;
import com.hackbright.capstone.entities.Patron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<OrderDto> getAllOrdersByPatronId(Patron patronId);

}
