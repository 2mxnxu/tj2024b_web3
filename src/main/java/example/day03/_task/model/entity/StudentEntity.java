package example.day03._task.model.entity;

import example.day03._task.model.dto.StudentDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity@Table(name = "day03student")
@Data @Builder
public class StudentEntity extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sno; // 학번
    @Column
    private String sname; //학생이름

    // FK 설정 , 단방향
    @ManyToOne
    private CourseEntity courseEntity;

    public StudentDto toDto() {
        return StudentDto.builder()
               .sno(this.sno)
               .sname(this.sname)
               .build();
    }
}