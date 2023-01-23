package com.hackbright.capstone.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.hackbright.capstone.dtos.LessonDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.ZonedDateTime;

@Entity
@Table(name = "lessons")
//@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lesson_time", unique = true)
    private ZonedDateTime lesson_time;

    @Column(name = "instrument_type")
    private String instrument_type;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;


    @ManyToOne
    @JoinColumn(name = "patron_id")
    private Patron patron;

}
