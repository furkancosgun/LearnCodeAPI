package com.furkancosgun.LearnCode.Controller;

import com.furkancosgun.LearnCode.Model.Lesson;
import com.furkancosgun.LearnCode.Service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/lessons")
public class LessonController {
    @Autowired
    private LessonService lessonService;


    @GetMapping
    public ResponseEntity<?> getAllLessons() {
        return ResponseEntity.ok(lessonService.getAllLessons());
    }

    @PostMapping
    public ResponseEntity<?> saveLesson(@RequestBody Lesson lesson) {
        return ResponseEntity.ok(lessonService.saveLesson(lesson));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSelectedLesson(@PathVariable long id) {
        return ResponseEntity.ok(lessonService.getSelectedLesson(id));
    }

    @GetMapping("/search")
    public ResponseEntity<?> getSearchedLessons(@RequestParam String p) {
        return ResponseEntity.ok(lessonService.getSearchedLessons(p));
    }

}
