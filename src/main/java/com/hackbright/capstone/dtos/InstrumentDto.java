package com.hackbright.capstone.dtos;

import com.hackbright.capstone.entities.Instrument;
import com.hackbright.capstone.entities.Lesson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstrumentDto {

    private Long id;
    private String instrumentName;
    private Integer price;
    private Integer quantity;

    private List<Lesson> lessons;

    public InstrumentDto(Instrument instrument) {
        if (instrument.getId()  !=  null) {
            this.id = instrument.getId();
        }
        if (instrument.getInstrumentName()  !=  null) {
            this.instrumentName = instrument.getInstrumentName();
        }
        if (instrument.getPrice()  !=  null) {
            this.price = instrument.getPrice();
        }
        if (instrument.getQuantity()  !=  null) {
            this.quantity = instrument.getQuantity();
        }
        if (instrument.getLessons() != null){
            this.lessons = instrument.getLessons();
        }
    }
}
