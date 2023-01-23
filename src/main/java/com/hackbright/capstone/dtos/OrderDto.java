package com.hackbright.capstone.dtos;

import com.hackbright.capstone.entities.Instrument;
import com.hackbright.capstone.entities.Order;
import com.hackbright.capstone.entities.Patron;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private Long id;
    private Patron patron;
    private Instrument instrument;
    private Integer quantity;

    public OrderDto(Order order) {
        if (order.getId() != null) {
            this.id = order.getId();
        }
        if (order.getPatron() != null) {
            this.patron = order.getPatron();
        }
        if (order.getInstrument() != null) {
            this.instrument = order.getInstrument();
        }
        if (order.getQuantity() != null) {
            this.quantity = order.getQuantity();
        }
    }
}
