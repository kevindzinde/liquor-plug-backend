package zw.tinkevtechnologies.liquorplugbackend.model;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class ShoppingCart {
    @Id
    private long id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;


}








