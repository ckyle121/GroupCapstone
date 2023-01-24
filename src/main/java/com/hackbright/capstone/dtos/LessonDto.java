package com.hackbright.capstone.dtos;


import com.hackbright.capstone.entities.Instructor;
import com.hackbright.capstone.entities.Lesson;
import com.hackbright.capstone.entities.Patron;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LessonDto implements Serializable {
    private Long id;
    private ZonedDateTime lesson_time;
    private String instrument_type;

    private Instructor instructor;

    private Patron patron;

    public LessonDto(Lesson lesson){
        if (lesson.getId() != null){
            this.id = lesson.getId();
        }
        if (lesson.getLesson_time() != null){
            this.lesson_time = lesson.getLesson_time();
        }
        if (lesson.getInstrument_type() != null){
            this.instrument_type = lesson.getInstrument_type();
        }
        if (lesson.getInstructor() != null){
            this.instructor = lesson.getInstructor();
        }
        if (lesson.getPatron() != null){
            this.patron = lesson.getPatron();
        }
    }
}
