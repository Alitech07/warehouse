package spring.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.warehouse.payload.ProductDto;
import spring.warehouse.payload.Result;
import spring.warehouse.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping
    public Result add(@RequestBody ProductDto productDto){
        Result result = productService.addProduct(productDto);
        return result;
    }
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id){
        Result result = productService.deleteProductService(id);
        return result;
    }
}
