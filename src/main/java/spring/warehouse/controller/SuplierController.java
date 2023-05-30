package spring.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.warehouse.entity.Supplier;
import spring.warehouse.payload.Result;
import spring.warehouse.service.SuplierService;

import java.util.List;

@RestController
@RequestMapping("/suplier")
public class SuplierController {
    @Autowired
    SuplierService suplierService;

    @GetMapping
    public List<Supplier> getSupplier(){
        return suplierService.getSuppliersService();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Supplier supplier){
        Result result = suplierService.addSupplier(supplier);
        return result;
    }

    @DeleteMapping("/delete/{id}")
    public Result deleteSupplier(@PathVariable Integer id){
        Result result = suplierService.deleteSuplierService(id);
        return result;
    }
}
