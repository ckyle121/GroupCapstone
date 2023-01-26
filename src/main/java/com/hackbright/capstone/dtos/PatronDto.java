package com.hackbright.capstone.dtos;

import com.hackbright.capstone.entities.Lesson;
import com.hackbright.capstone.entities.Patron;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatronDto {
    private Long id;

    private String patronName;

    private List<Lesson> lessons;


    public PatronDto(Patron patron) {
        if (patron.getId() != null) {
            this.id = patron.getId();
        }
        if (patron.getPatronName() != null) {
            this.patronName = patron.getPatronName();
        }
        if (patron.getLessons() != null) {
            this.lessons = patron.getLessons();
        }
    }
}