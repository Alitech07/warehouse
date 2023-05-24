package spring.warehouse.service;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import spring.warehouse.entity.Attachment;
import spring.warehouse.entity.AttachmentContent;
import spring.warehouse.payload.Result;
import spring.warehouse.repository.AttachmentContentRepository;
import spring.warehouse.repository.AttachmentRepository;

import java.io.IOException;
import java.util.Iterator;

@Service
public class AttachmentService {
    @Autowired
    AttachmentRepository attachmentRepository;
    @Autowired
    AttachmentContentRepository attachmentContentRepository;

    @SneakyThrows
    public Result uploadFile(MultipartHttpServletRequest request) {
        Iterator<String> fileName = request.getFileNames();
        MultipartFile file = request.getFile(fileName.next());
        if (file.isEmpty())
            return new Result("file error",false);
        Attachment attachment = new Attachment();
        attachment.setName(file.getOriginalFilename());
        attachment.setSize(file.getSize());
        attachment.setContentType(file.getContentType());
        Attachment savedAttachment = attachmentRepository.save(attachment);

        AttachmentContent attachmentContent = new AttachmentContent();
        attachmentContent.setBytes(file.getBytes());
        attachmentContent.setAttachment(attachment);
        attachmentContentRepository.save(attachmentContent);

        return new Result("Upload File",true,savedAttachment.getId());
    }
}
