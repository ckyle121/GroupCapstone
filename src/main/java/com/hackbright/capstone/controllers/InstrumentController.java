package com.hackbright.capstone.controllers;

import com.hackbright.capstone.dtos.InstrumentDto;
import com.hackbright.capstone.services.InstrumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/instrument")
public class InstrumentController {

    @Autowired
    private InstrumentService instrumentService;

    @PostMapping("/addInstrument/{instrumentId}")
    public void addInstrument (@RequestBody InstrumentDto instrumentDto, @PathVariable Long instrumentId) {
        instrumentService.addInstrument(instrumentDto);
    }

    @DeleteMapping("/deleteInstrument")
    public void deleteInstrument (InstrumentDto instrumentDto) {
        instrumentService.deleteInstrument(instrumentDto);
    }

    @PostMapping("/createInstrument")
    public void createInstrument (InstrumentDto instrumentDto) {
        instrumentService.createInstrument(instrumentDto);
    }

    @GetMapping("/getAllInventory")
    public void getAllInventory() {
        System.out.println(instrumentService.getAllInventory());
    }

    @GetMapping("/test")
    public void test() {
        InstrumentDto instrumentDto = new InstrumentDto(null, "Trombone", 199, 8, null);
        instrumentService.createInstrument(instrumentDto);
        System.out.println(instrumentDto);
    }

}
