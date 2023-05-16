package spring.warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.warehouse.entity.OutputProdact;
import spring.warehouse.payload.OutputProductDto;
import spring.warehouse.payload.Result;
import spring.warehouse.repository.OutputProductReposiotry;

import java.util.List;
import java.util.Optional;

@Service
public class OutputProductService {
    @Autowired
    OutputProductReposiotry outputProductReposiotry;

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
        return new Result();
    }
}
