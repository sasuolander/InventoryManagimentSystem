package inventorysystem.object;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long productId;
    private  int productNumber;
    private  int partNumber;
    private String productLabel;
    private int startingInventory;
    private int inventoryOnHand;
    private  int minimumRequired;
    @ManyToOne
    @JoinColumn(name="orderId")
    private  Order productList;

    //Default constructor
    public Product(){
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
}
