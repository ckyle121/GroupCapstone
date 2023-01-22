package com.hackbright.capstone.entities;

import com.hackbright.capstone.dtos.InstructorDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Instructor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "instructorName")
    private String instructorName;

    public Instructor(InstructorDto instructorDto){
        if (instructorDto.getInstructorName() != null){
            this.instructorName = instructorDto.getInstructorName();
        }
    }
}
