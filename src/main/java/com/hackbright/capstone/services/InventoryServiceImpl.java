package com.hackbright.capstone.services;

import com.hackbright.capstone.dtos.InstrumentDto;
import com.hackbright.capstone.entities.Instrument;
import com.hackbright.capstone.repositories.InstrumentRepository;
import com.hackbright.capstone.repositories.OrderRepository;
import com.hackbright.capstone.repositories.PatronRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private InstrumentRepository instrumentRepository;

    @Autowired
    private PatronRepository patronRepository;

    @Override
    @Transactional
    public void addInventory(InstrumentDto instrumentDto) {
        Optional<Instrument> instrumentOptional = instrumentRepository.findById(instrumentDto.getId());
        instrumentOptional.ifPresent(instrument -> {
            instrument.setQuantity(instrumentDto.getQuantity());
            instrumentRepository.saveAndFlush(instrument);
        });
    }

    @Transactional
    public void deleteInventory(InstrumentDto instrumentDto) {
        Optional<Instrument> instrumentOptional = instrumentRepository.findById(instrumentDto.getId());
        instrumentOptional.ifPresent(instrument -> {
            instrument.setQuantity(instrumentDto.getQuantity());
            instrumentRepository.saveAndFlush(instrument);
        });
    }

    public void getAllInventory(List<InstrumentDto> instrumentList) {

        for (InstrumentDto each : instrumentList
        ) {
            System.out.println(each);
        };
    }
}
