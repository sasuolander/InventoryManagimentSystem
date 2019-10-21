package inventorysystem.object.entity;

import inventorysystem.object.PersistentObject;
import inventorysystem.object.pojo.ProductPOJO;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@EqualsAndHashCode
public class Product implements PersistentObject<Product, ProductPOJO>, Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue
    private Long productId;
    private int productNumber;
    private int partNumber;
    private String productLabel;
    private int startingInventory;
    private int inventoryOnHand;
    private int minimumRequired;
    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;

    //Default constructor
    public Product() {
        //Default constructor for hibernate
    }

    public Long getProductId() {
        return productId;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public int getPartNumber() {
        return partNumber;
    }

    public String getProductLabel() {
        return productLabel;
    }

    public int getStartingInventory() {
        return startingInventory;
    }

    public int getInventoryOnHand() {
        return inventoryOnHand;
    }

    public int getMinimumRequired() {
        return minimumRequired;
    }


    public Product translatePojoToPersistent(ProductPOJO objectPojo) {
        this.inventoryOnHand = objectPojo.getInventoryOnHand();
        this.minimumRequired = objectPojo.getMinimumRequired();
        this.partNumber = objectPojo.getPartNumber();
        this.productId = objectPojo.getProductId();
        this.productLabel = objectPojo.getProductLabel();
        this.productNumber = objectPojo.getProductNumber();
        this.startingInventory = objectPojo.getStartingInventory();
        return this;
    }
}
