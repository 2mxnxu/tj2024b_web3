package example.day03._task.model.dto;

import example.day03._task.model.entity.CourseEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CourseDto {
    private int cno;
    private String cname;

    public CourseEntity toEntity(){
        return CourseEntity.builder()
               .cno(cno)
               .cname(cname)
               .build();
    }
}
