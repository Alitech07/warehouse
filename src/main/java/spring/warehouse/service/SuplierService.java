package spring.warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.warehouse.entity.Supplier;
import spring.warehouse.payload.Result;
import spring.warehouse.repository.SuplierRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SuplierService {
    @Autowired
    SuplierRepository suplierRepository;

    /**
     *
     * @return
     */
    public List<Supplier> getSuppliersService(){
        return suplierRepository.findAll();
    }


    /**
     *Yangi yetkazib beruvchilarni qo'shish.
     * @param supplier
     * @return
     */
    public Result addSupplier(Supplier supplier){
        boolean exists = suplierRepository.existsByPhoneNumber(supplier.getPhoneNumber());
        if (exists)
            return new Result("This phone number already exists",false);
        suplierRepository.save(supplier);
        return new Result("Added Supplier",true);
    }

    /**
     * Supplierni id bo'yicha o'chirish.
     * @param id
     * @return
     */
    public Result deleteSuplierService(Integer id){
        Optional<Supplier> optionalSupplier = suplierRepository.findById(id);
        if (!optionalSupplier.isPresent()) return new Result("This Suplier not found!",false);
        suplierRepository.deleteById(id);
        return new Result("Deleted Suplier.",true);
    }
}
