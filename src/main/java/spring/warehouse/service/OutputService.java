package spring.warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.warehouse.entity.Output;
import spring.warehouse.payload.OutputDto;
import spring.warehouse.payload.Result;
import spring.warehouse.repository.OutputRepository;

import java.util.List;

@Service
public class OutputService {
    @Autowired
    OutputRepository outputRepository;

    /**
     * Barcha chiqimlarni listini qaytaradi.
     * @return
     */
    public List<Output> getOutputsService(){
        return outputRepository.findAll();
    }

    public Result addOutputService(OutputDto outputDto){
        return new Result();
    }
}
