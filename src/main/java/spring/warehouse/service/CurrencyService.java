package spring.warehouse.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.warehouse.entity.Currency;
import spring.warehouse.payload.Result;
import spring.warehouse.repository.CurrencyRepository;

@Service
public class CurrencyService {

    @Autowired
    CurrencyRepository currencyRepository;

    public Result addCurrency(Currency currency){
        boolean exists = currencyRepository.existsByName(currency.getName());
        if (exists)
            return new Result("This Currency already exists",false);
        currencyRepository.save(currency);
        return new Result("Added Currency",true);
    }
}
