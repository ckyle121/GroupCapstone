package com.hackbright.capstone.dtos;

import com.hackbright.capstone.entities.Patron;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.hackbright.capstone.entities.Order;
import com.hackbright.capstone.entities.Patron;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatronDto implements Serializable {
    private Long id;
    private String patronName;

    private Set<LessonDto> lessonDtoSet = new HashSet<>();

    public PatronDto(Patron patron){
        if (patron.getId() != null){
            this.id = patron.getId();
        }
        if (patron.getPatronName() != null){
            this.patronName = patron.getPatronName();
        }
    }

        if (patron.getOrders() != null) {
            this.orders = patron.getOrders();
        }
    }

}
