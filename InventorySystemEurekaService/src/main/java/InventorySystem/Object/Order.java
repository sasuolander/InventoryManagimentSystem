package InventorySystem.Object;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Order {
    @Id
    @GeneratedValue
    private final Long order_id;
    private final String title;
    private  final String first;
    private final  String last;
    private final  Long product_id;
    private final int number_shipped;
    private final int order_date;

    private Order(Builder builder) {
        order_id = builder.order_id;
        title = builder.title;
        first = builder.first;
        last = builder.last;
        product_id = builder.product_id;
        number_shipped = builder.number_shipped;
        order_date = builder.order_date;
    }

    public static final class Builder {
        private final Long order_id;
        private String title;
        private String first;
        private String last;
        private Long product_id;
        private int number_shipped;
        private int order_date;

        public Builder(Long order_id) {
            this.order_id = order_id;
        }

        public Builder setTitle(String val) {
            title = val;
            return this;
        }

        public Builder setFirst(String val) {
            first = val;
            return this;
        }

        public Builder setLast(String val) {
            last = val;
            return this;
        }

        public Builder setProduct_id(Long val) {
            product_id = val;
            return this;
        }

        public Builder setNumber_shipped(int val) {
            number_shipped = val;
            return this;
        }

        public Builder setOrder_date(int val) {
            order_date = val;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}
