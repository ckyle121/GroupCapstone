package com.hackbright.capstone.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @ManyToOne
    @JoinColumn(name = "patron_id")
    private Patron patron;

    @ManyToOne
    @JoinColumn(name = "instrument_id")
    private Instrument instrument;

    public Lesson(LessonDto lessonDto) {
        if (lessonDto.getLesson_time() != null) {
            this.lesson_time = lessonDto.getLesson_time();
        }
        if (lessonDto.getInstructor() != null) {
            this.instructor = lessonDto.getInstructor();
        }
        if (lessonDto.getPatron() != null) {
            this.patron = lessonDto.getPatron();
        }
        if (lessonDto.getInstrument() != null) {
            this.instrument = lessonDto.getInstrument();
        }
    }
}