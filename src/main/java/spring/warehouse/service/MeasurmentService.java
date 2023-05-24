package spring.warehouse.service;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.warehouse.entity.Measurement;
import spring.warehouse.payload.Result;
import spring.warehouse.repository.MeasurmentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MeasurmentService {
    @Autowired
    MeasurmentRepository measurmentRepository;
    public List<Measurement> getMeasurmentsService(){
        return measurmentRepository.findAll();
    }

    /**
     * Ma'lumotlar bazasidan measurmentni id bo'yicha olish.
     * @param id
     * @return
     */
    public Measurement getMeasurmentService(Integer id){
        Optional<Measurement> optionalMeasurement = measurmentRepository.findById(id);
        return optionalMeasurement.orElse(null);
    }
    public Result addMeasurment(Measurement measurement){
        boolean exists = measurmentRepository.existsByName(measurement.getName());
        if (exists)
            return new Result("This Measurment already exists",false);

        measurmentRepository.save(measurement);
        return new Result("Added Measurment",true);
    }

    /**
     * Ma'lumotlar bazasidan o'lchob birligini id bo'yicha o'chirish.
     * @param id
     * @return
     */
    public Result deleteMeasurmentService(Integer id){
        Optional<Measurement> optionalMeasurement = measurmentRepository.findById(id);
        if (!optionalMeasurement.isPresent()) return new Result("Bunday o'lchov birligi mavjud emas.",false);
        measurmentRepository.deleteById(id);
        return new Result("O'lchov birliglari o'chirildi.",true);
    }
}
