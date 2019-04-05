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

    //https://stackoverflow.com/questions/27987068/spring-boot-hibernate-syntax-error-in-sql-statement
    private final int numberShipped;
    private final Date orderDate;

    private Order(Builder builder) {
        orderId = builder.orderId;
        title = builder.title;
        firstName = builder.first;
        lastName = builder.last;
        numberShipped = builder.numberShipped;
        orderDate = builder.orderDate;
    }

    public static final class Builder {
        private final Long orderId;
        private String title;
        private String first;
        private String last;
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


    public Long getOrderId() {
        return orderId;
    }

    public String getTitle() {
        return title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Product> getProductList() {
        return productList;
    }


    public int getNumberShipped() {
        return numberShipped;
    }

    public Date getOrderDate() {
        return orderDate;
    }
}
