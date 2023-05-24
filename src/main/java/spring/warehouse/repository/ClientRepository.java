package spring.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.warehouse.entity.Client;

public interface ClientRepository extends JpaRepository<Client,Integer> {
    boolean existsByPhoneNumber(String phoneNumber);
}
