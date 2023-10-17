package zw.tinkevtechnologies.liquorplugbackend.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class UserCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private int quantity;



}
