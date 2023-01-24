package com.hackbright.capstone.services;

import com.hackbright.capstone.dtos.InstrumentDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public interface InventoryService {

    @Transactional
    void addInventory(InstrumentDto instrumentDto);

    @Transactional
    void deleteInventory(InstrumentDto instrumentDto);

    void getAllInventory(List<InstrumentDto> instrumentList);

}
