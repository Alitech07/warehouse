package spring.warehouse.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.warehouse.entity.Warehouse;
import spring.warehouse.payload.Result;
import spring.warehouse.repository.WarehouseRepository;

@Service
public class WarehouseService {
    @Autowired
    WarehouseRepository warehouseRepository;

    public Result addWarehouse(Warehouse warehouse){
        boolean exists = warehouseRepository.existsByName(warehouse.getName());
        if (exists)
            return new Result("This warehouse already exists",false);
        warehouseRepository.save(warehouse);
        return new Result("Warehouse added",true);
    }

}
