package inventorysystem.object.entity;

import inventorysystem.object.PersistentObject;
import inventorysystem.object.pojo.ProductPOJO;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@EqualsAndHashCode
@Table(name = "product_table")
public class Product implements PersistentObject<Product, ProductPOJO>, Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue
    private Long Id;
    @Column(name = "productId",unique = true)
    private String productId;
    @Column(name = "productNumber")
    private int productNumber;
    @Column(name = "partNumber")
    private int partNumber;
    @Column(name = "productLabel")
    private String productLabel;
    @Column(name = "startingInventory")
    private int startingInventory;
    @Column(name = "inventoryOnHand")
    private int inventoryOnHand;
    @Column(name = "minimumRequired")
    private int minimumRequired;
    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;

    //Default constructor
    public Product() {
        //Default constructor for hibernate
    }

    public String getProductId() {
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
