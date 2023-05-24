package spring.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import spring.warehouse.entity.Warehouse;
import spring.warehouse.payload.Result;
import spring.warehouse.service.WarehouseService;

import javax.persistence.GeneratedValue;

@Controller
@RequestMapping("/home")
public class WarehouseController {
    @Autowired
    WarehouseService warehouseService;
    @PostMapping
    public Result add(@RequestBody Warehouse warehouse){
       Result result = warehouseService.addWarehouse(warehouse);
       return result;
    }
}
