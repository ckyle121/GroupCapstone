package com.hackbright.capstone.controllers;

import com.hackbright.capstone.dtos.InstrumentDto;
import com.hackbright.capstone.dtos.PatronDto;
import com.hackbright.capstone.services.InstrumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/instruments")
public class InstrumentController {

    @Autowired
    private InstrumentService instrumentService;

    @PostMapping
    public void addInstrument (@RequestBody InstrumentDto instrumentDto) {
        instrumentService.addInstrument(instrumentDto);
    }

    @DeleteMapping("/{instrumentId}")
    public void deleteInstrument (@PathVariable Long instrumentId) {
        instrumentService.deleteInstrument(instrumentId);
    }

    @PutMapping
    public void updateInstrument (@RequestBody InstrumentDto instrumentDto) {
        instrumentService.updateInstrument(instrumentDto);
    }

    @GetMapping
    public List<InstrumentDto> getAllInstruments() {
        return instrumentService.getAllInstruments();
    }

    @GetMapping("/{instrumentId}")
    public Optional<InstrumentDto> getInstrumentById(@PathVariable Long instrumentId) {
        return instrumentService.getInstrumentById(instrumentId);
    }

}
