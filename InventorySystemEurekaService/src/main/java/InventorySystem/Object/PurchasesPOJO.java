package inventorysystem.object;

import java.util.Date;

public class PurchasesPOJO {
    private  Long purchasesId;
    private  Long supplierId;
    private  Long productId;
    private  int numberReceived;
    private  Date purchaseDate;

    private PurchasesPOJO(Builder builder) {
        purchasesId = builder.purchasesId;
        supplierId = builder.supplierId;
        productId = builder.productId;
        numberReceived = builder.numberReceived;
        purchaseDate = builder.purchaseDate;
    }

    public static final class Builder {
        private Long purchasesId;
        private Long supplierId;
        private Long productId;
        private int numberReceived;
        private Date purchaseDate;

        public Builder() {
        }

        public Builder setPurchasesId(Long val) {
            purchasesId = val;
            return this;
        }

        public Builder setSupplierId(Long val) {
            supplierId = val;
            return this;
        }

        public Builder setProductId(Long val) {
            productId = val;
            return this;
        }

        public Builder setNumberReceived(int val) {
            numberReceived = val;
            return this;
        }

        public Builder setPurchaseDate(Date val) {
            purchaseDate = val;
            return this;
        }

        public PurchasesPOJO build() { return new PurchasesPOJO(this); }
    }

}