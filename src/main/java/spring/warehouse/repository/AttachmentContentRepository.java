package spring.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.warehouse.entity.Attachment;
import spring.warehouse.entity.AttachmentContent;

public interface AttachmentContentRepository extends JpaRepository<AttachmentContent,Integer> {
}
