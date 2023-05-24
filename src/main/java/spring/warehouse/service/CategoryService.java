package spring.warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import spring.warehouse.entity.Category;
import spring.warehouse.payload.CategoryDto;
import spring.warehouse.payload.Result;
import spring.warehouse.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    /**
     * MA'LUMOTLAR BAZASIGA YANGI CATEOGRY QO'SHISH.
     * @param categoryDto
     * @return RESULT OBYEKTI QAYTARILADI.
     */
    public Result addCategory(CategoryDto categoryDto){
        Category category = new Category();
        category.setName(categoryDto.getName());
        if (categoryDto.getParentCategoryId()!=null){
            Optional<Category> optionalCategory = categoryRepository.findById(categoryDto.getParentCategoryId());
            if (!optionalCategory.isPresent())
                return new Result("This Parent category not found",true);
            category.setParentCategory(optionalCategory.get());
        }
        categoryRepository.save(category);
        return new Result("Added Category",true);
    }

    /**
     * MA'LUMOTLAR BAZASIDAN BARCHA CATEGORYLARNI OLIB KELISH.
     * @return CATEGORYLAR LISTINI QAYTARADI.
     */
    public List<Category> getCategories(){
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }

    /**
     * CATEGORY NOMLARINI YANGILASH.
     * @param categoryDto
     * @return
     */
    public Result editCategoryService(CategoryDto categoryDto){
        Optional<Category> optionalCategory = categoryRepository.findById(categoryDto.getParentCategoryId());
        if (optionalCategory.isPresent()){
            return new Result("Bunday category mavjud.", false);
        }
        Category category = new Category();
        category.setName(categoryDto.getName());
        Category referenceById = categoryRepository.getReferenceById(categoryDto.getParentCategoryId());
        category.setParentCategory(referenceById);
        categoryRepository.save(category);
        return new Result();
    }

    /**
     * Categoryni id bo'yicha o'chirish.
     * @param id
     * @return
     */
    public Result deleteCategory(Integer id){
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (!optionalCategory.isPresent()) return new Result("Bunday Category mavjud emas.",false);
        categoryRepository.deleteById(id);
        return new Result("Category o'chirildi.",true);
    }
}
