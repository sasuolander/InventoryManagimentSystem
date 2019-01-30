package InventorySystem.Object;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Purchaces {
    @Id
    @GeneratedValue
    private final Long purchases_id;
    private final Long supplier_id;
    private final Long product_id;
    private final int number_received;
    private final Date purchase_date;

    private Purchaces(Builder builder) {
        purchases_id = builder.purchases_id;
        supplier_id = builder.supplier_id;
        product_id = builder.product_id;
        number_received = builder.number_received;
        purchase_date = builder.purchase_date;
    }


    public static final class Builder {
        private Long purchases_id;
        private Long supplier_id;
        private Long product_id;
        private int number_received;
        private Date purchase_date;

        public Builder() {
        }

        public Builder setPurchases_id(Long val) {
            purchases_id = val;
            return this;
        }

        public Builder setSupplier_id(Long val) {
            supplier_id = val;
            return this;
        }

        public Builder setProduct_id(Long val) {
            product_id = val;
            return this;
        }

        public Builder setNumber_received(int val) {
            number_received = val;
            return this;
        }

        public Builder setPurchase_date(Date val) {
            purchase_date = val;
            return this;
        }

        public Purchaces build() {
            return new Purchaces(this);
        }
    }
}
