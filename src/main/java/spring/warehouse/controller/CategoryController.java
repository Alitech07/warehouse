package spring.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.warehouse.entity.Category;
import spring.warehouse.payload.CategoryDto;
import spring.warehouse.payload.Result;
import spring.warehouse.service.CategoryService;
import java.util.*;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    /**
     * YANGI KATEGORIYA QO'SHISH
     * @param categoryDto
     * @return RESULT OBYEKTI QAYTARILADI. UNDA MESSAGE(QO'SHILGAN YOKI QO'SHILMAGANLIK XABARI)
     * VA TRUE, FALSE
     */
    @PostMapping
    public Result add(@RequestBody CategoryDto categoryDto){
        Result result = categoryService.addCategory(categoryDto);
        return result;
    }

    @PutMapping("/{id}")
    public HttpEntity<?> edit(@RequestBody CategoryDto categoryDto,@PathVariable Integer id){
        Result result = categoryService.editCategoryService(categoryDto);
        return ResponseEntity.status(result.isSuccess()?200:409).body(result);
    }

    /**
     * BARCHA KATEGORIYALARNI BAZADAN OLISH.
     * @return KATEGORIYALAR LISTINI QAYTARADI.
     */
    @GetMapping
    public List<Category> getCategory(){
        List<Category> categories = categoryService.getCategories();
        return categories;
    }

}
