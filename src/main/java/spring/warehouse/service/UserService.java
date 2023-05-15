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
import java.util.List;
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

    public List<User> getUsers(){
        List<User> users = userRepository.findAll();
        return users;
    }

    public Result getUser(Integer id){
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()){
            User user = userOptional.get();
            return new Result("Ajoyib ",true,user);
        }
        return new Result("User not found", false);
    }

    public Result editUser(UserDto userDto,Integer id){
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()){
            return new Result("User not found",false);
        }
        User user = optionalUser.get();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(userDto.getPassword());

        userRepository.save(user);

        return new Result("User edited",true);
    }

    public Result deleteUser(Integer id){
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) return new Result("User not found",false);
        userRepository.deleteById(id);
        return new Result("User delete",true);
    }
}
