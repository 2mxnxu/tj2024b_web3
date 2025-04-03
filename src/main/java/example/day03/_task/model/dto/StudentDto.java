package example.day03._task.model.dto;

import example.day03._task.model.entity.StudentEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentDto {
    private int sno;
    private String sname;
    private int cno;

    public StudentEntity toEntity(){
        return StudentEntity.builder()
               .sno(sno)
               .sname(sname)
               .build();
    }
}
