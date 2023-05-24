package spring.warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.warehouse.entity.Output;
import spring.warehouse.entity.OutputProdact;
import spring.warehouse.entity.Product;
import spring.warehouse.payload.OutputProductDto;
import spring.warehouse.payload.Result;
import spring.warehouse.repository.OutputProductReposiotry;
import spring.warehouse.repository.OutputRepository;
import spring.warehouse.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OutputProductService {
    @Autowired
    OutputProductReposiotry outputProductReposiotry;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OutputRepository outputRepository;

    /**
     * Sotilgan mahsulotlar ro'yhati
     * @return
     */
    public List<OutputProdact> getOutputProductService(){
        return outputProductReposiotry.findAll();
    }

    /**
     * sotilgan mahsulotni ko'rish
     * @param id
     * @return
     */
    public OutputProdact getOutputProduct(Integer id){
        Optional<OutputProdact> optionalOutputProdact = outputProductReposiotry.findById(id);
        return optionalOutputProdact.get();
    }

    public Result addOutputProudct(OutputProductDto outputProductDto){
        OutputProdact outputProdact = new OutputProdact();
        outputProdact.setAmount(outputProductDto.getAmount());
        outputProdact.setPrice(outputProductDto.getPrice());

        Optional<Product> optionalProduct = productRepository.findById(outputProductDto.getProductId());
        if (!optionalProduct.isPresent()) return new Result("Bunday product mavjud eams.",false);
        outputProdact.setProduct(optionalProduct.get());

        Optional<Output> optionalOutput = outputRepository.findById(outputProductDto.getOutputId());
        if (!optionalOutput.isPresent()) return new Result("Bunday chiqimlar tarixi mavjud emas.",false);
        outputProdact.setOutput(optionalOutput.get());

        outputProductReposiotry.save(outputProdact);

        return new Result("Yangi mahsulot chiqimi kiritildi.",true);
    }

    public Result deleteOutputProduct(Integer id) {
        Optional<OutputProdact> optionalOutputProdact = outputProductReposiotry.findById(id);
        if (!optionalOutputProdact.isPresent()) return new Result("Bunday mahsulot chiqimi mavjud emas.",false);
        return new Result("o'chirildi.",true);
    }
}
