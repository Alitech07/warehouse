package spring.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.warehouse.entity.Supplier;
import spring.warehouse.payload.Result;
import spring.warehouse.service.SuplierService;

@RestController
@RequestMapping("/suplier")
public class SuplierController {
    @Autowired
    SuplierService suplierService;

    @PostMapping
    public Result add(@RequestBody Supplier supplier){
        Result result = suplierService.addSupplier(supplier);
        return result;
    }
}
