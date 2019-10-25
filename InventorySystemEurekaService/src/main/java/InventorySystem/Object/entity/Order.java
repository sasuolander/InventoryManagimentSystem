package inventorysystem.object.entity;
import inventorysystem.object.pojo.OrderPOJO;
import inventorysystem.object.PersistentObject;
import lombok.EqualsAndHashCode;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "order_table") //Order word is reserved in sql
@EqualsAndHashCode
public class  Order implements PersistentObject<Order, OrderPOJO>, Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @Column(name = "orderId")
    private Long orderId;
    @Column(name = "title")
    @Nullable
    private String title;
    @Column(name = "firstName")
    @Nullable
    private String firstName;
    @Column(name = "lastName")
    @Nullable
    private  String lastName;
    @Column(name = "productList")
    @Nullable
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,mappedBy = "order")
    private  List<Product>productList= new ArrayList<>();

    //https://stackoverflow.com/questions/27987068/spring-boot-hibernate-syntax-error-in-sql-statement
    @Nullable
    private  int numberShipped;
    @Nullable
    private Date orderDate;


    //Default constructor
    public Order(){
        //Default constructor for hibernate
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

    @Override
    public Order translatePojoToPersistent(OrderPOJO orderPOJO){
         this.orderId=orderPOJO.getOrderId();
          this.title=orderPOJO.getTitle();
         this.firstName=orderPOJO.getFirstName();
         this.lastName=orderPOJO.getLastName();
        this.numberShipped=orderPOJO.getNumberShipped();
        this.orderDate=orderPOJO.getOrderDate();
        this.productList=null;
        return  this;
    }
}
