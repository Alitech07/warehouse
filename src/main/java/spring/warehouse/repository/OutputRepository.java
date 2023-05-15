package spring.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.warehouse.entity.Output;

public interface OutputRepository extends JpaRepository<Output,Integer> {
}
