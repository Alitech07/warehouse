package spring.warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.warehouse.repository.OutputProductReposiotry;

@Service
public class OutputProductService {
    @Autowired
    OutputProductReposiotry outputProductReposiotry;
}
