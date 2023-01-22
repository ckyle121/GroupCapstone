package com.hackbright.capstone.dtos;


import com.hackbright.capstone.entities.Lesson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LessonDto implements Serializable {
    private Long id;
    private Timestamp lessonTime;
    private String instrumentType;

    private InstructorDto instructorDto;

    private PatronDto patronDto;

    public LessonDto(Lesson lesson){
        if (lesson.getId() != null){
            this.id = lesson.getId();
        }
        if (lesson.getLessonTime() != null){
            this.lessonTime = lesson.getLessonTime();
        }
        if (lesson.getInstrumentType() != null){
            this.instrumentType = lesson.getInstrumentType();
        }
    }
}
