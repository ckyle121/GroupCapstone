package com.hackbright.capstone.services;

import com.hackbright.capstone.dtos.InstrumentDto;
import com.hackbright.capstone.dtos.PatronDto;
import com.hackbright.capstone.entities.Instrument;
import com.hackbright.capstone.entities.Patron;
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

    @Override
    @Transactional
    public void addInstrument(InstrumentDto instrumentDto) {
            Instrument instrument = new Instrument(instrumentDto);
            instrumentRepository.saveAndFlush(instrument);
    }

    @Override
    @Transactional
    public void updateInstrument(InstrumentDto instrumentDto) {
        Optional<Instrument> instrumentOptional = instrumentRepository.findById(instrumentDto.getId());
        instrumentOptional.ifPresent(instrument -> {
            instrument.setInstrumentName(instrumentDto.getInstrumentName());
            instrument.setQuantity(instrumentDto.getQuantity());
            instrument.setPrice(instrumentDto.getPrice());
            instrument.setLessons(instrumentDto.getLessons());
            instrumentRepository.saveAndFlush(instrument);
        });
    }

    @Override
    @Transactional
    public void deleteInstrument(Long instrumentId) {
        Optional<Instrument> instrumentOptional = instrumentRepository.findById(instrumentId);
        instrumentOptional.ifPresent(instrument -> instrumentRepository.delete(instrument));
    }

    @Override
    public List<InstrumentDto> getAllInstruments() {
        List<Instrument> instrumentList = instrumentRepository.findAll();
        return instrumentList.stream().map(instrument ->
            new InstrumentDto(instrument)).collect(Collectors.toList());
    }

    @Override
    public Optional<InstrumentDto> getInstrumentById(Long instrumentId) {
        Optional<Instrument> instrumentOptional = instrumentRepository.findById(instrumentId);
        if (instrumentOptional.isPresent()){
            return Optional.of(new InstrumentDto(instrumentOptional.get()));
        }
        return Optional.empty();
    }
}
