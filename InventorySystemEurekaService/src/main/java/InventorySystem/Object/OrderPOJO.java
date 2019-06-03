package inventorysystem.object;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderPOJO {
              private Long orderId;
        private String title;
        private String firstName;
        private  String lastName;

        //https://stackoverflow.com/questions/27987068/spring-boot-hibernate-syntax-error-in-sql-statement
        private  int numberShipped;

        private Date orderDate;
        //Default constructor
        public OrderPOJO(){
        }
        private OrderPOJO(Builder builder) {
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
            public OrderPOJO build() {
                return new OrderPOJO(this);
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


    public int getNumberShipped() {
        return numberShipped;
    }

    public Date getOrderDate() {
        return orderDate;
    }
}
