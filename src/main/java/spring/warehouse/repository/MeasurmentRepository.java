package spring.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.warehouse.entity.Measurement;

public interface MeasurmentRepository  extends JpaRepository<Measurement,Integer> {
    boolean existsByName(String name);
}
