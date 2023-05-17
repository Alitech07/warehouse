package spring.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import spring.warehouse.payload.OutputDto;
import spring.warehouse.payload.Result;
import spring.warehouse.service.OutputService;

@Controller
@RequestMapping("/output")
public class OutputController {
    @Autowired
    OutputService outputService;
    @GetMapping
    public HttpEntity<?> getOutput(){
        return ResponseEntity.ok(outputService.getOutputsService());
    }

    @PostMapping("/add")
    public HttpEntity<?> addOutput(@RequestBody OutputDto outputDto){
        Result result = outputService.addOutputService(outputDto);
        return ResponseEntity.status(result.isSuccess()?202:409).body(result);
    }

    @PutMapping("/edit/{id}")
    public HttpEntity<?> editOutput(@RequestBody OutputDto outputDto,Integer id){
        Result result = outputService.editOutputService(outputDto, id);
        return ResponseEntity.status(result.isSuccess()?201:409).body(result);
    }

}
