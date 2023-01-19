package com.furkancosgun.LearnCode.Service;

import com.furkancosgun.LearnCode.Model.Lesson;
import com.furkancosgun.LearnCode.Repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {
    @Autowired
    private LessonRepository lessonRepository;

    public Lesson saveLesson(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    public List<Lesson> getAllLessons() {
        return lessonRepository.findAll();
    }

    public Lesson getSelectedLesson(long id) {
        return lessonRepository.findById(id).orElseThrow();
    }

    public List<Lesson> getSearchedLessons(String title) {
        return lessonRepository.findByTitleContains(title);
    }
}
