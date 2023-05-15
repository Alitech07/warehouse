package spring.warehouse.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import spring.warehouse.payload.Result;
import spring.warehouse.service.AttachmentService;

import java.util.List;

@RestController
@RequestMapping("/attechment")
public class AttachmentController {
    @Autowired
    AttachmentService attachmentService;

    @PostMapping
    public Result upload(MultipartHttpServletRequest request){
        Result result = attachmentService.uploadFile(request);
        return result;
    }


}
