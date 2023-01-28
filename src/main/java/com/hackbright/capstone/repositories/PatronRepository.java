package com.hackbright.capstone.repositories;

import com.hackbright.capstone.entities.Patron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatronRepository extends JpaRepository <Patron, Long> {
    Optional<Patron> findByPatronName(String patronName);
}
