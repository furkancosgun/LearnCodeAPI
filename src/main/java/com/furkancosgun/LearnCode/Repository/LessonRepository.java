package com.furkancosgun.LearnCode.Repository;

import com.furkancosgun.LearnCode.Model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
    List<Lesson> findByTitleContains(String title);
}
