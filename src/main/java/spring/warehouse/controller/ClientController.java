package spring.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.warehouse.entity.Client;
import spring.warehouse.payload.Result;
import spring.warehouse.service.CilentService;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    CilentService cilentService;

    @GetMapping
    public List<Client> getClients(){
        List<Client> clients = cilentService.getClientsService();
        return clients;
    }

    @PostMapping
    public Result add(@RequestBody Client client){
            Result result = cilentService.addClientService(client);
            return result;
    }

    @PutMapping("/{id}")
    public Result edit(@RequestBody Client client){
        return new Result("Client o'chirildi.",true);
    }
}
