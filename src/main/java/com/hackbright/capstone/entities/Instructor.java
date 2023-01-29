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
    private String instructorName;

    @OneToMany(mappedBy = "instructor")
    @JsonBackReference
    private List<Lesson> lessons;

    public Instructor (InstructorDto instructorDto) {
        if (instructorDto.getId() != null) {
            this.id = instructorDto.getId();
        }
        if (instructorDto.getInstructorName() != null) {
            this.instructorName = instructorDto.getInstructorName();
        }
        if (instructorDto.getLessons() != null) {
            this.lessons = instructorDto.getLessons();
        }
    }
}
