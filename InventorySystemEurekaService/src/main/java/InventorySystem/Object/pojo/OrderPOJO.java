package inventorysystem.object.pojo;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

 @EqualsAndHashCode
 @ToString
 @Builder(builderMethodName = "Builder")
 public class OrderPOJO {
        private Long orderId;
        private String title;
        private String firstName;
        private  String lastName;
        private  int numberShipped;
        private Date orderDate;
        private List<ProductPOJO> productList=new ArrayList<>();

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

     public List<ProductPOJO> getProductList() {
         return productList;
     }

     public Date getOrderDate() {
        return orderDate;
    }
 }
