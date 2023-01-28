package com.hackbright.capstone.services;

import com.hackbright.capstone.dtos.InstrumentDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public interface InstrumentService {

    @Transactional
    void addInstrument(InstrumentDto instrumentDto);
    @Transactional
    void createInstrument(InstrumentDto instrumentDto);
    @Transactional
    void deleteInstrument(InstrumentDto instrumentDto);

  List<InstrumentDto> getAllInventory();

}
