package com.hackbright.capstone.entities;

import com.hackbright.capstone.dtos.OrderDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patron_id")
    private Patron patron;

    @ManyToOne
    @JoinColumn(name="instrument_id")
    private Instrument instrument;

    @Column (name = "quantity")
    private Integer quantity;

    public Order(OrderDto orderDto) {
        if (orderDto.getId() != null) {
            this.id = orderDto.getId();
        }
        if (orderDto.getPatron() != null) {
            this.patron = orderDto.getPatron();
        }
        if (orderDto.getInstrument() != null) {
            this.instrument = orderDto.getInstrument();
        }
        if (orderDto.getQuantity() != null) {
            this.quantity = orderDto.getQuantity();
        }
    }
}
