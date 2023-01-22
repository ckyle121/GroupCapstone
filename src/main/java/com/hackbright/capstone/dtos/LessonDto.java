package com.hackbright.capstone.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Books")
//@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LessonDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rating")
    private Timestamp lessonTime;
}
