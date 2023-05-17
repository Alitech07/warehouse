package spring.warehouse.payload;

import lombok.Data;
import spring.warehouse.entity.Client;
import spring.warehouse.entity.Currency;
import spring.warehouse.entity.Warehouse;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

@Data
public class OutputDto {
    private Warehouse warehouse;
    private Integer clientId;
    private Integer currencyId;
    private String code;
}
