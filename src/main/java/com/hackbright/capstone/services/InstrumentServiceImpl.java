package com.hackbright.capstone.services;

import com.hackbright.capstone.dtos.InstrumentDto;
import com.hackbright.capstone.entities.Instrument;
import com.hackbright.capstone.repositories.InstrumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InstrumentServiceImpl implements InstrumentService {

    @Autowired
    private InstrumentRepository instrumentRepository;

    @Transactional
    public void addInstrument(InstrumentDto instrumentDto) {
        Optional<Instrument> instrumentOptional = instrumentRepository.findById(instrumentDto.getId());
        instrumentOptional.ifPresent(instrument -> {
            instrument.setQuantity(instrumentDto.getQuantity());
            instrumentRepository.saveAndFlush(instrument);
        });
    }

    @Transactional
    public void createInstrument(InstrumentDto instrumentDto) {
            Instrument instrument = new Instrument(instrumentDto);
            instrumentRepository.saveAndFlush(instrument);
    }

    @Transactional
    public void deleteInstrument(InstrumentDto instrumentDto) {
        Optional<Instrument> instrumentOptional = instrumentRepository.findById(instrumentDto.getId());
        instrumentOptional.ifPresent(instrument -> {
            instrument.setQuantity(instrumentDto.getQuantity());
            instrumentRepository.saveAndFlush(instrument);
        });
    }

    public List<InstrumentDto> getAllInventory() {
        List<Instrument> instrumentList = instrumentRepository.findAll();
        return instrumentList.stream().map(instrument ->
            new InstrumentDto(instrument)).collect(Collectors.toList());
    }
}
