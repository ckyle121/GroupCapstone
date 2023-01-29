package com.hackbright.capstone.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hackbright.capstone.dtos.InstrumentDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "instruments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Instrument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "instrument_name")
    private String instrumentName;

    @Column(name = "price")
    private Integer price;

    @Column(name = "quantity")
    private Integer quantity;

    @OneToMany(mappedBy = "instrument")
    @JsonBackReference
    private List<Lesson> lessons;

    public Instrument(InstrumentDto instrumentDto) {
        if (instrumentDto.getInstrumentName() != null) {
            this.instrumentName = instrumentDto.getInstrumentName();
        } if (instrumentDto.getPrice() != null) {
            this.price = instrumentDto.getPrice();
        }if (instrumentDto.getQuantity() != null) {
            this.quantity = instrumentDto.getQuantity();
        }
    }
}
