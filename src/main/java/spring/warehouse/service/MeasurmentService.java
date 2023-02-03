package spring.warehouse.service;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.warehouse.entity.Measurement;
import spring.warehouse.payload.Result;
import spring.warehouse.repository.MeasurmentRepository;

import java.util.Optional;

@Service
public class MeasurmentService {
    @Autowired
    MeasurmentRepository measurmentRepository;
    public Result addMeasurment(Measurement measurement){
        boolean exists = measurmentRepository.existsByName(measurement.getName());
        if (exists)
            return new Result("This Measurment already exists",false);

        measurmentRepository.save(measurement);
        return new Result("Added Measurment",true);
    }
}
