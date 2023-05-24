package spring.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.warehouse.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
