package example.day04.task.controller;

import example.day04.task.model.dto.TaskDto;
import example.day04.task.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/day04/task")
@RequiredArgsConstructor
public class taskController {
    private final TaskService taskService;

    @PostMapping
    public TaskDto taskSave(@RequestBody TaskDto taskDto) {
        return taskService.taskSave(taskDto);
    }
    @GetMapping
    public List<TaskDto> taskFindAll() {
        return taskService.taskFindAll();
    }
    @GetMapping("/view")
    public TaskDto taskFindById(@RequestParam int pid) {
        return taskService.taskFindById(pid);
    }
    @PutMapping
    public TaskDto taskUpdate(@RequestBody TaskDto taskDto) {
        return taskService.taskUpdate(taskDto);
    }
    @DeleteMapping
    public boolean taskDelete(@RequestParam int pid) {
        return taskService.taskDelete(pid);
    }
    @GetMapping("/page")
    public List<TaskDto> taskFindByPage(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        return taskService.taskFindByPage(page, size);
    }
}
