package com.hackbright.capstone.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.hackbright.capstone.dtos.LessonDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Lessons")
//@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lessonTime", unique = true)
    private Timestamp lessonTime;

    @Column(name = "instrumentType")
    private String instrumentType;

    @ManyToOne
    @JsonBackReference
    private Instructor instructor;

    @ManyToOne
    @JsonBackReference
    private Patron patron;

    public Lesson(LessonDto lessonDto){
        if (lessonDto.getLessonTime() != null){
            this.lessonTime = lessonDto.getLessonTime();
        }
        if (lessonDto.getInstrumentType() != null){
            this.instrumentType = lessonDto.getInstrumentType();
        }
    }
}
