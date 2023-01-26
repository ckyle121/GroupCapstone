package com.hackbright.capstone.dtos;


import com.hackbright.capstone.entities.Instructor;
import com.hackbright.capstone.entities.Instrument;
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

    private Instructor instructor;

    private Patron patron;

    private Instrument instrument;

    public LessonDto(Lesson lesson){
        if (lesson.getId() != null){
            this.id = lesson.getId();
        }
        if (lesson.getLesson_time() != null){
            this.lesson_time = lesson.getLesson_time();
        }
        if (lesson.getInstructor() != null){
            this.instructor = lesson.getInstructor();
        }
        if (lesson.getPatron() != null){
            this.patron = lesson.getPatron();
        }
        if (lesson.getInstrument() != null){
            this.instrument = lesson.getInstrument();
        }
    }
}
