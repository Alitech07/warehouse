package spring.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.warehouse.entity.OutputProdact;

public interface OutputProductReposiotry extends JpaRepository<OutputProdact,Integer> {
}