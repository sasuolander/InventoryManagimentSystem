package inventorysystem.object;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Purchaces {
    @Id
    @GeneratedValue
    private final Long purchasesId;
    private final Long supplierId;
    private final Long productId;
    private final int numberReceived;
    private final Date purchaseDate;



    private Purchaces(Builder builder) {
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

        public Purchaces build() {
            return new Purchaces(this);
        }
    }

    public Long getPurchasesId() {
        return purchasesId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public Long getProductId() {
        return productId;
    }

    public int getNumberReceived() {
        return numberReceived;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }
}
