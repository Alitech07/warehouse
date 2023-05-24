package spring.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.warehouse.entity.Client;
import spring.warehouse.payload.Result;
import spring.warehouse.service.CilentService;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    CilentService cilentService;

    @PostMapping
    public Result add(@RequestBody Client client){
            Result result = cilentService.addClient(client);
            return result;
    }
}
