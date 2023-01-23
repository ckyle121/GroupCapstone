package com.hackbright.capstone.dtos;

import com.hackbright.capstone.entities.Order;
import com.hackbright.capstone.entities.Patron;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatronDto {
    private Long id;

    private String patron_name;

    private List<Order> orders;


    public PatronDto(Patron patron) {
        if (patron.getId() != null) {
            this.id = patron.getId();
        }
        if (patron.getPatron_name() != null) {
            this.patron_name = patron.getPatron_name();
        }
        if (patron.getOrders() != null) {
            this.orders = patron.getOrders();
        }
    }

}
