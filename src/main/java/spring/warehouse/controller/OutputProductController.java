package spring.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.warehouse.entity.OutputProdact;
import spring.warehouse.payload.OutputProductDto;
import spring.warehouse.payload.Result;
import spring.warehouse.service.OutputProductService;
import spring.warehouse.service.OutputService;

import java.util.List;

@RestController
@RequestMapping("/outputproduct")
public class OutputProductController {
    @Autowired
    OutputProductService outputProductService;

    @GetMapping
    public HttpEntity<?> getOutputProducts(){
        List<OutputProdact> prodactList = outputProductService.getOutputProductService();
        return ResponseEntity.ok(prodactList);
    }

    @PostMapping("/add")
    public HttpEntity<?> addOutputProduct(@RequestBody OutputProductDto outputProductDto){
        Result result = outputProductService.addOutputProudct(outputProductDto);
        return ResponseEntity.status(result.isSuccess()?202:409).body(result);
    }
}
