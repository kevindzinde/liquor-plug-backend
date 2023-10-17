package zw.tinkevtechnologies.liquorplugbackend.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private String paymentId;
    private double amountPaid;
    private double change;
    private String currency;
    private LocalDateTime paymentDate;
    private String paymentType;

}
