package spring.warehouse.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.warehouse.entity.Output;
import spring.warehouse.entity.Product;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutputProductDto {
    private Integer productId;
    private double amount;
    private double price;
    private Date expireDate;
    private Integer outputId;
}
