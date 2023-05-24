package spring.warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.warehouse.entity.Client;
import spring.warehouse.entity.Output;
import spring.warehouse.payload.OutputDto;
import spring.warehouse.payload.Result;
import spring.warehouse.repository.ClientRepository;
import spring.warehouse.repository.OutputRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OutputService {
    @Autowired
    OutputRepository outputRepository;
    @Autowired
    ClientRepository clientRepository;

    /**
     * Barcha chiqimlarni listini qaytaradi.
     * @return
     */
    public List<Output> getOutputsService(){
        return outputRepository.findAll();
    }

    /**
     * Yangi chiqimlar tarixi qo'shildi.
     * @param outputDto
     * @return
     */
    public Result addOutputService(OutputDto outputDto){
        Output output = new Output();
        Optional<Client> optionalClient = clientRepository.findById(outputDto.getClientId());
        output.setClient(optionalClient.get());
        
        return new Result("Chiqim qo'shildi.",true);
    }

    /**
     * Chiqimlar tarixini yangilash
     * @param outputDto
     * @param id
     * @return
     */
    public Result editOutputService(OutputDto outputDto, Integer id) {
        return new Result("Chiqim malumotlari yangilandi.",true);
    }

    /**
     * Chiqimlar tarixini o'chirish.
     * @param id
     * @return
     */
    public Result deleteOutputService(Integer id){
        Optional<Output> optionalOutput = outputRepository.findById(id);
        if (!optionalOutput.isPresent()) return new Result("bunday  chimiq mavjud emas",false);
        return new Result("Chiqimlar tarixi o'chirildi.",true);
    }

}
