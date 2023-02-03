package spring.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.warehouse.entity.Measurement;
import spring.warehouse.payload.Result;
import spring.warehouse.service.MeasurmentService;

@RestController
@RequestMapping("/measurment")
public class MeasurmentController {

    @Autowired
    MeasurmentService measurmentService;
    @PostMapping
    public Result add(@RequestBody Measurement measurement){
        Result result = measurmentService.addMeasurment(measurement);
        return result;
    }
}
