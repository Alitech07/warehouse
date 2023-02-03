package spring.warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.warehouse.entity.Client;
import spring.warehouse.payload.Result;
import spring.warehouse.repository.ClientRepository;

import java.util.Optional;

@Service
public class CilentService {
    @Autowired
    ClientRepository clientRepository;

    public Result addClient(Client client){
        boolean exists = clientRepository.existsByPhoneNumber(client.getPhoneNumber());
        if (exists)
            return new Result("This phone number already exists",false);
        clientRepository.save(client);
        return new Result("Added Client",true);
    }

}
