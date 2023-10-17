package zw.tinkevtechnologies.liquorplugbackend.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class OrderInvoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private String orderInvoiceId;
    private long userid;
    @OneToOne
    private UserCart userCart;
    @OneToOne
    private DeliveryDetail deliveryDetail;
    private double orderInvoiceTotal;
    @OneToOne
    private Payment payment;
    private String status;

}
