package spring.warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.warehouse.payload.Result;
import spring.warehouse.repository.InputRepository;

@Service
public class InputService {
    @Autowired
    InputRepository inputRepository;

    public Result addInput(){

        return new Result("Added input product",true);
    }
}
