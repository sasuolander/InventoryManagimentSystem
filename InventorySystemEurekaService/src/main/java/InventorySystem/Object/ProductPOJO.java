package inventorysystem.object;

public class ProductPOJO {
    private Long productId;
    private  int productNumber;
    private  int partNumber;
    private String productLabel;
    private int startingInventory;
    private int inventoryOnHand;
    private  int minimumRequired;
    private  Order productList;

    private ProductPOJO(Builder builder) {
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
        public ProductPOJO build() {
            return new ProductPOJO(this);
        }
    }
}