package inventorysystem.object;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private final Long productId;
    private final int productNumber;
    private final int partNumber;
    private final String productLabel;
    private final int startingInventory;
    private final int inventoryOnHand;
    private final int minimumRequired;
    @ManyToOne
    @JoinColumn
    private  Order productList;

    private Product(Builder builder) {
        productId = builder.productId;
        productNumber = builder.productNumber;
        partNumber = builder.partNumber;
        productLabel = builder.productLabel;
        startingInventory = builder.startingInventory;
        inventoryOnHand = builder.inventoryOnHand;
        minimumRequired = builder.minimumRequired;
    }


    public static final class Builder {
        private final Long productId;
        private int productNumber;
        private int partNumber;
        private String productLabel;
        private int startingInventory;
        private int inventoryOnHand;
        private int minimumRequired;

        public Builder(Long productId) {
            this.productId = productId;
        }

        public Builder setProductNumber(int val) {
            productNumber = val;
            return this;
        }

        public Builder setPartNumber(int val) {
            partNumber = val;
            return this;
        }

        public Builder setProductLabel(String val) {
            productLabel = val;
            return this;
        }

        public Builder setStartingInventory(int val) {
            startingInventory = val;
            return this;
        }

        public Builder setInventoryOnHand(int val) {
            inventoryOnHand = val;
            return this;
        }

        public Builder setMinimumRequired(int val) {
            minimumRequired = val;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
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
