package inventorysystem.object.pojo;

import lombok.Builder;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Builder(builderClassName = "Builder")
public class ProductPOJO {
    private Long productId;
    private  int productNumber;
    private  int partNumber;
    private String productLabel;
    private int startingInventory;
    private int inventoryOnHand;
    private  int minimumRequired;
    //private OrderPOJO productList;

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