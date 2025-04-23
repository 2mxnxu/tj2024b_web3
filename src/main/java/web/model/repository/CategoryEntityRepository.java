package web.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.model.entity.CategoryEntity;

public interface CategoryEntityRepository extends JpaRepository<CategoryEntity, Long> {
}
