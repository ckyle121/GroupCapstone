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
    private String instrument_name;

    @Column(name = "price")
    private Integer price;

    @Column(name = "quantity")
    private Integer quantity;

    @OneToMany(mappedBy = "instrument")
    @JsonBackReference
    private List<Lesson> lessons;

    public Instrument(InstrumentDto instrumentDto) {
        if (instrumentDto.getInstrument_name() != null) {
            this.instrument_name = instrumentDto.getInstrument_name();
        } if (instrumentDto.getPrice() != null) {
            this.price = instrumentDto.getPrice();
        }if (instrumentDto.getQuantity() != null) {
            this.quantity = instrumentDto.getQuantity();
        }
    }
}
