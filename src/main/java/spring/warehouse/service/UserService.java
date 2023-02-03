package spring.warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.warehouse.entity.User;
import spring.warehouse.entity.Warehouse;
import spring.warehouse.payload.Result;
import spring.warehouse.payload.UserDto;
import spring.warehouse.repository.UserRepository;
import spring.warehouse.repository.WarehouseRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    WarehouseRepository warehouseRepository;

    public Result addUser(UserDto userDto){
        boolean exists = userRepository.existsByPhoneNumber(userDto.getPhoneNumber());
        if (exists)
            return new Result("This phone number already exists",false);
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(userDto.getWarehouseId());
        if (!optionalWarehouse.isPresent())
            return new Result("Warehouse not found",false);
        Set<Warehouse> warehouses = new HashSet<>();
        warehouses.add(optionalWarehouse.get());
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setCode("1");
        user.setPassword(userDto.getPassword());
        user.setWarehouses(warehouses);
        return new Result("Added User",true);
    }
}
