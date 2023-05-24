package spring.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.warehouse.entity.Supplier;

public interface SuplierRepository extends JpaRepository<Supplier,Integer> {
    boolean existsByPhoneNumber(String phoneNumber);
}
