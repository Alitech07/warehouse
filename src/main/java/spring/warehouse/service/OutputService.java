package spring.warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.warehouse.repository.OutputRepository;

@Service
public class OutputService {
    @Autowired
    OutputRepository outputRepository;
}
