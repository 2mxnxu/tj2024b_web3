package example.day04.task.model.entity;

import example.day04.task.model.dto.TaskDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskEntity extends BaseTime{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;
    private String pname;
    private String pdescription;
    private int pquantity;

    public TaskDto toTaskDto(){
        return TaskDto.builder()
               .pid(this.pid)
               .pname(this.pname)
               .pdescription(this.pdescription)
               .pquantity(this.pquantity)
                .createAt( this.getCreateAt() )
                .updateAt( this.getUpdateAt() )
               .build();
    }
}
