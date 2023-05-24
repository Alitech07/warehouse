package spring.warehouse.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.warehouse.entity.Currency;
import spring.warehouse.payload.Result;
import spring.warehouse.repository.CurrencyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyService {

    @Autowired
    CurrencyRepository currencyRepository;

    /**
     * Ma'lumotlar bazasidan barcha pul birliklari ro'yhatini olish.
     * @return
     */
    public List<Currency> getCurrenciesService(){
        return currencyRepository.findAll();
    }

    /**
     * Ma'lumotlar bazasidan Pul birligini id bo'yicha olib kelish.
     * @param id
     * @return
     */
    public Currency getCurrencyService(Integer id){
        Optional<Currency> optionalCurrency = currencyRepository.findById(id);
        return optionalCurrency.orElse(null);
    }

    /**
     * Malumotlar bazasiga yangi pul birligi qo'shish.
     * @param currency
     * @return
     */
    public Result addCurrency(Currency currency){
        boolean exists = currencyRepository.existsByName(currency.getName());
        if (exists)
            return new Result("This Currency already exists",false);
        currencyRepository.save(currency);
        return new Result("Added Currency",true);
    }

    /**
     * Malumotlar Bazasidan pul birligini o'chirilsh.
     * @param id
     * @return
     */
    public Result deleteCurrencyService(Integer id){
        Optional<Currency> optionalCurrency = currencyRepository.findById(id);
        if (!optionalCurrency.isPresent()) return new Result("Bunday pul birligi mavjud emas!",false);
        currencyRepository.deleteById(id);
        return new Result("Pul birligi o'chirildi",true);
    }
}
