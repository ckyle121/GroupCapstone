package com.hackbright.capstone.repositories;

import com.hackbright.capstone.dtos.InstrumentDto;
import com.hackbright.capstone.entities.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstrumentRepository extends JpaRepository<Instrument, Long> {
//    List<InstrumentDto> getAllInventory();
}
