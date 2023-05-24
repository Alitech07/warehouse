package spring.warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import spring.warehouse.entity.Input;
import spring.warehouse.payload.InputDto;
import spring.warehouse.payload.Result;
import spring.warehouse.repository.InputRepository;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.time.Instant;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class InputService {
    @Autowired
    InputRepository inputRepository;

    /**
     * Ma'lumotlar bazasidan Kirimlar tarixlari ro'yxatini olish.
     * @return
     */
    public List<Input> getInputsService(){
        return inputRepository.findAll();
    }

    /**
     * Ma'lumotlar bazasiga Yangi kirimlar qo'shish.
     * @param inputDto
     * @return
     */
    public Result addInput(InputDto inputDto){
        boolean exist = inputRepository.existsByCode(inputDto.getCode());
        if (exist){
            return new Result("Bu mahsulotlarni oldin kirim qilgansiz",false);
        }
        Instant time = Instant.now();
        Timestamp timestamp = Timestamp.from(time);
        Input input = new Input();
        input.setCode(inputDto.getCode());
        input.setDate(timestamp);

        return new Result("Added input product",true);
    }

    /**
     * Ma'lumotlar bazasidan kirimlar tarixini ID bo'yicha o'chirish.
     * @param id
     * @return
     */
    public Result deleteInputServiece(Integer id){
        Optional<Input> optionalInput = inputRepository.findById(id);
        if (!optionalInput.isPresent()) return new Result("Bunday kirimlar tarixi mavjud emas.",false);
        inputRepository.deleteById(id);
        return new Result("Kirimlar tarixi o'chirildi.",true);
    }

}
