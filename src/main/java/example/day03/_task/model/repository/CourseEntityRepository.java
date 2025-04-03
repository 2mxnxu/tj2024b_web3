package example.day03._task.model.repository;

import example.day03._task.model.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseEntityRepository extends JpaRepository<CourseEntity, Integer> {

}
