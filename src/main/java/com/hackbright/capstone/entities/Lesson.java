package com.hackbright.capstone.entities;

import com.hackbright.capstone.dtos.LessonDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Lesson")
//@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rating")
    private Timestamp lessonTime;

    public Lesson(LessonDto lessonDto){
        if (lessonDto.getLessonTime() != null){
            this.lessonTime = lessonDto.getLessonTime();
        }
    }
}
