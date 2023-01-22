package com.hackbright.capstone.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hackbright.capstone.dtos.InstructorDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Instructors")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "instructorName")
    private String instructorName;

    @OneToMany(mappedBy = "instructor", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonManagedReference
    private Set<Lesson> lessonSet = new HashSet<>();

    public Instructor(InstructorDto instructorDto){
        if (instructorDto.getInstructorName() != null){
            this.instructorName = instructorDto.getInstructorName();
        }
    }
}
