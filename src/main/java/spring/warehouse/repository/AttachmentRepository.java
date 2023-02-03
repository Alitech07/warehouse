package spring.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.warehouse.entity.Attachment;

public interface AttachmentRepository extends JpaRepository<Attachment,Integer> {
}
