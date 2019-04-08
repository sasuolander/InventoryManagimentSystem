package inventorysystem.object;

import lombok.Builder;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "order_table") //Order word is reserved in sql
public class Order {
    @Id
    @GeneratedValue
    private Long orderId;
    @Nullable
    private String title;
    @Nullable
    private String firstName;
    @Nullable
    private  String lastName;
    @Nullable
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Product>productList= new ArrayList<>();

    //https://stackoverflow.com/questions/27987068/spring-boot-hibernate-syntax-error-in-sql-statement
    @Nullable
    private  int numberShipped;
    @Nullable
    private Date orderDate;


    //Default constructor
    public Order(){}
    private Order(Builder builder) {
        orderId = builder.orderId;
        title = builder.title;
        firstName = builder.firstName;
        lastName = builder.lastName;
        numberShipped = builder.numberShipped;
        orderDate = builder.orderDate;
    }

    public static final class Builder {
        private final Long orderId;
        private String title;
        private String firstName;
        private String lastName;
        private int numberShipped;
        private Date orderDate;

        public Builder(Long orderId ) {
            this.orderId = orderId;
        }

        public Builder setTitle(String val) {
            title = val;
            return this;
        }

        public Builder setFirstName(String val) {
            firstName = val;
            return this;
        }

        public Builder setLastName(String val) {
            lastName = val;
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
