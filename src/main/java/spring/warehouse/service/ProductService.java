package spring.warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.warehouse.entity.Attachment;
import spring.warehouse.entity.Category;
import spring.warehouse.entity.Measurement;
import spring.warehouse.entity.Product;
import spring.warehouse.payload.ProductDto;
import spring.warehouse.payload.Result;
import spring.warehouse.repository.AttachmentRepository;
import spring.warehouse.repository.CategoryRepository;
import spring.warehouse.repository.MeasurmentRepository;
import spring.warehouse.repository.ProductRepository;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    AttachmentRepository attachmentRepository;
    @Autowired
    MeasurmentRepository measurmentRepository;

    public Result addProduct(ProductDto productDto){
        boolean exists = productRepository.existsByNameAndCategoryId(productDto.getName(),productDto.getCategoryId());
        if (exists){
            return new Result("This Product the category already exists",false);
        }
        Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategoryId());
        if (!optionalCategory.isPresent())
            return new Result("This Category not found",false);
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(productDto.getPhotoId());
        if (!optionalAttachment.isPresent())
            return new Result("This Photo not found",false);
        Optional<Measurement> optionalMeasurement = measurmentRepository.findById(productDto.getMeasurmentId());
        if (!optionalMeasurement.isPresent())
            return new Result("Mashurment topilmadi",false);
        Product product = new Product();
        product.setName(productDto.getName());
        product.setCode("1");
        product.setCategory(optionalCategory.get());
        product.setPhoto(optionalAttachment.get());
        product.setMeasurement(optionalMeasurement.get());
        productRepository.save(product);
        return new Result("Added Product",true);
    }

}
