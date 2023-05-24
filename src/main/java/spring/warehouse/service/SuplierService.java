package spring.warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.warehouse.entity.Supplier;
import spring.warehouse.payload.Result;
import spring.warehouse.repository.SuplierRepository;

@Service
public class SuplierService {
    @Autowired
    SuplierRepository suplierRepository;
    public Result addSupplier(Supplier supplier){
        boolean exists = suplierRepository.existsByPhoneNumber(supplier.getPhoneNumber());
        if (exists)
            return new Result("This phone number already exists",false);
        suplierRepository.save(supplier);
        return new Result("Added Supplier",true);
    }
}
