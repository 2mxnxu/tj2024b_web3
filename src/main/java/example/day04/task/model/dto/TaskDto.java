package example.day04.task.model.dto;

import example.day04.task.model.entity.TaskEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data@NoArgsConstructor@AllArgsConstructor@Builder
public class TaskDto {
    private int pid;
    private String pname;
    private String pdescription;
    private int pquantity;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public TaskEntity toTaskEntity() {
        return TaskEntity.builder()
               .pid(this.pid)
               .pname(this.pname)
               .pdescription(this.pdescription)
               .pquantity(this.pquantity)
               .build();
    }

}
