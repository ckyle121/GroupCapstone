package com.hackbright.capstone.services;

import com.hackbright.capstone.dtos.InstrumentDto;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface InstrumentService {
    @Transactional
    void addInstrument(InstrumentDto instrumentDto);

    @Transactional
    void updateInstrument(InstrumentDto instrumentDto);

    @Transactional
    void deleteInstrument(Long instrumentId);

    List<InstrumentDto> getAllInstruments();

    Optional<InstrumentDto> getInstrumentById(Long instrumentId);
}
