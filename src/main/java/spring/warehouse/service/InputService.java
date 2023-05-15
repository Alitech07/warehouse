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
import java.util.Optional;

@Service
public class InputService {
    @Autowired
    InputRepository inputRepository;

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
}
