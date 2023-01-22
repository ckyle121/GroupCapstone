package com.hackbright.capstone.entities;

import com.hackbright.capstone.dtos.PatronDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "patrons")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patron {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patron_name")
    private String patron_name;

    @OneToMany(mappedBy = "patron")
    private List<Order> orders;

}
