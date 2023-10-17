package zw.tinkevtechnologies.liquorplugbackend.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class DeliveryDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userid;
    private String company;
    private String streetAddress;
    private String houseNumber;
    private String town;
    private String zipCode;
    private String notes ;
}
