package spring.warehouse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/dashbord")
public class DashbordController {
    @GetMapping
    public String getDashbord(){
        return "dashbort";
    }
}
