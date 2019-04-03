package InventorySystem.Object;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Order {
    @Id
    @GeneratedValue
    private final Long orderId;
    private final String title;
    private  final String firstName;
    private final  String lastName;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Product>productList= new ArrayList<>();

    private final  Long productId;
    private final int numberShipped;
    private final Date orderDate;

    private Order(Builder builder) {
        orderId = builder.orderId;
        title = builder.title;
        firstName = builder.first;
        lastName = builder.last;
        productId = builder.productId;
        numberShipped = builder.numberShipped;
        orderDate = builder.orderDate;
    }

    public static final class Builder {
        private final Long orderId;
        private String title;
        private String first;
        private String last;
        private Long productId;
        private int numberShipped;
        private Date orderDate;

        public Builder(Long orderId ) {
            this.orderId = orderId;
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

        public Builder setProductId(Long val) {
            productId = val;
            return this;
        }

        public Builder setNumberShipped(int val) {
            numberShipped = val;
            return this;
        }

        public Builder setOrderDate(Date val) {
            orderDate = val;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}
