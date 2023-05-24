package spring.warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;
import spring.warehouse.entity.Client;
import spring.warehouse.payload.Result;
import spring.warehouse.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CilentService {
    @Autowired
    ClientRepository clientRepository;

    /**
     * Ma'lumotlar bazasidan Clientlar ro'yxatini olish,
     * @return
     */
    public List<Client> getClientsService(){
        return clientRepository.findAll();
    }

    /**
     * Ma'lumotlar bazasiga yangi client qo'shish.
     * @param client
     * @return
     */
    public Result addClientService(Client client){
        boolean exists = clientRepository.existsByPhoneNumber(client.getPhoneNumber());
        if (exists)
            return new Result("This phone number already exists",false);
        clientRepository.save(client);
        return new Result("Added Client",true);
    }

    /**
     * Id bo'yicha DataBase dan client malumotlarini o'chirish.
     * @param id
     * @return
     */
    public Result deleteClientService(Integer id){
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (!optionalClient.isPresent()) return new Result("Bunday client topilmadi.",false);
        clientRepository.deleteById(id);
        return new Result("Client o'chirildi.",false);
    }
}
