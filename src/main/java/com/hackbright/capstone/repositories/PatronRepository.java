package com.hackbright.capstone.repositories;

import com.hackbright.capstone.dtos.OrderDto;
import com.hackbright.capstone.dtos.PatronDto;
import com.hackbright.capstone.entities.Patron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatronRepository extends JpaRepository <Patron, Long> {


}
