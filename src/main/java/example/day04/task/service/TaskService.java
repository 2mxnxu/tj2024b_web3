package example.day04.task.service;

import example.day04.task.model.dto.TaskDto;
import example.day04.task.model.entity.TaskEntity;
import example.day04.task.model.repository.TaskRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskDto taskSave(TaskDto taskDto) {
        TaskEntity taskEntity = taskDto.toTaskEntity();
        TaskEntity saveEntity = taskRepository.save( taskEntity );
        if (saveEntity.getPid() > 0) {
            return saveEntity.toTaskDto();
        }else {
            return null;
        }
    }
    public List<TaskDto> taskFindAll() {
        List<TaskEntity> taskEntityList = taskRepository.findAll();
        List<TaskDto> taskDtoList = new ArrayList<>();
        for (int i = 0; i < taskEntityList.size(); i++) {
            TaskDto taskDto = taskEntityList.get(i).toTaskDto();
            taskDtoList.add(taskDto);
        }
        return taskDtoList;
    }
    public TaskDto taskFindById(int pid) {
        Optional<TaskEntity> optional = taskRepository.findById(pid);
        if (optional.isPresent()) {
            TaskEntity taskEntity = optional.get();
            TaskDto taskDto = taskEntity.toTaskDto();
            return taskDto;
        }
        return null;
    }
    public TaskDto taskUpdate( TaskDto taskDto) {
        Optional<TaskEntity> optional = taskRepository.findById(taskDto.getPid());
        if (optional.isPresent()) {
            TaskEntity taskEntity = optional.get();
            taskEntity.setPname(taskDto.getPname());
            taskEntity.setPdescription(taskDto.getPdescription());
            taskEntity.setPquantity(taskDto.getPquantity());
            return taskEntity.toTaskDto();
        }
        return null;
    }
    public boolean taskDelete(int pid) {
        boolean result = taskRepository.existsById(pid);
        if (result == true) {
            taskRepository.deleteById(pid);
            return true;
        }
        return false;
    }
    public List<TaskDto> taskFindByPage(int page, int size) {
        PageRequest pageRequest =  PageRequest.of( page-1 ,  size , Sort.by( Sort.Direction.DESC , "pid" ) );
        return taskRepository.findAll(pageRequest).stream()
                .map( TaskEntity::toTaskDto )
                .collect(Collectors.toList());
    }
}
