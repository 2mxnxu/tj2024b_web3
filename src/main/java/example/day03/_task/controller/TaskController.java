package example.day03._task.controller;

import example.day03._task.model.dto.CourseDto;
import example.day03._task.model.dto.StudentDto;
import example.day03._task.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/day03/task")
public class TaskController {
    private final TaskService taskService;
    // 1. 등록
    @PostMapping("/course")
    // http://localhost:8080/day03/task/course
    // { "cname" : "수학" }
    public boolean saveCourse(@RequestBody CourseDto courseDto ){
        System.out.println("TaskController.saveCourse");
        System.out.println("courseDto = " + courseDto);
        return taskService.saveCourse( courseDto );
    }
    @GetMapping("/course")
    public List<CourseDto> findAll() {
        return taskService.findAll();
    }
    @PostMapping("/student")
    public boolean saveStudent(@RequestBody StudentDto studentDto) {
        return taskService.saveStudent(studentDto);
    }
    @GetMapping("/student")
    public List<StudentDto> findAllStudent( @RequestParam int cno ){
        return taskService.findAllStudent( cno );
    }
}
