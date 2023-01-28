package com.hackbright.capstone.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hackbright.capstone.dtos.InstructorDto;
import com.hackbright.capstone.dtos.InstrumentDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "instructors")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "instructor_name")
    private String instructor_name;

    @OneToMany(mappedBy = "instructor")
    @JsonBackReference
    private List<Lesson> lessons;

    public Instructor(InstructorDto instructorDto) {
        if (instructorDto.getInstructor_name() != null) {
            this.instructor_name = instructorDto.getInstructor_name();
        }
    }
}
