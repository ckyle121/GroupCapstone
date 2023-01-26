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
    private String patronName;

    @OneToMany(mappedBy = "patron")
    private List<Lesson> lessons;


    public Patron (PatronDto patronDto) {
        if (patronDto.getId() != null) {
            this.id = patronDto.getId();
        }
        if (patronDto.getPatronName() != null) {
            this.patronName = patronDto.getPatronName();
        }
        if (patronDto.getLessons() != null) {
            this.lessons = patronDto.getLessons();
        }
    }
}