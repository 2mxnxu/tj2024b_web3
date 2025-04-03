package example.day03._task.model.repository;

import example.day03._task.model.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentEntityRepository extends JpaRepository<StudentEntity, Integer> {
}
