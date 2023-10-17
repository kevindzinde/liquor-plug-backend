package zw.tinkevtechnologies.liquorplugbackend.model;

import zw.tinkevtechnologies.liquorplugbackend.utils.enums.ProductCatergory;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productCode;
    private String description;
    private String status;
    private String brand;
    private LocalDateTime datecreated;
    private Double price;
    private ProductCatergory productCatergory;

    private boolean isDeleted;
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public ProductCatergory getProductCatergory() {
        return productCatergory;
    }


    public void setProductCatergory(ProductCatergory productCatergory) {
        this.productCatergory = productCatergory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public LocalDateTime getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(LocalDateTime datecreated) {
        this.datecreated = datecreated;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
