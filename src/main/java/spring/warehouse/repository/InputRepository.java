package spring.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.warehouse.entity.Input;

public interface InputRepository extends JpaRepository<Input,Integer> {
        boolean existsByCode(String code);
}
