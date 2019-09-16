package inventorysystem.object;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "order_table") //Order word is reserved in sql
public class Order implements PersistentObject<Order,OrderPOJO>{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;
    @Nullable
    private String title;
    @Nullable
    private String firstName;
    @Nullable
    private  String lastName;
    @Nullable
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,mappedBy = "productList")
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
