package spring.warehouse.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import spring.warehouse.entity.template.AbsEntity;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Warehouse extends AbsEntity {
}
