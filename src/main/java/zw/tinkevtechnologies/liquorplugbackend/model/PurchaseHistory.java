package zw.tinkevtechnologies.liquorplugbackend.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class PurchaseHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private User user;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private Double price;
    private LocalDateTime purchasetime;

}
