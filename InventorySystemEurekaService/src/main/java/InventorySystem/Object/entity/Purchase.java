package inventorysystem.object.entity;

import inventorysystem.object.PersistentObject;
import inventorysystem.object.pojo.PurchasesPOJO;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@EqualsAndHashCode
@Table(name = "purchase_table")
public class Purchase implements PersistentObject<Purchase, PurchasesPOJO>, Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue
    private Long Id;
    @Column(name = "purchaseId",unique = true)
    private  String purchaseId;
    @Column(name = "supplierId")
    private  String supplierId;
    @Column(name = "productId")
    private  String productId;
    @Column(name = "numberReceived")
    private  int numberReceived;
    @Column(name = "purchaseDate")
    private  Date purchaseDate;

    //Default constructor
    public Purchase(){
        //Default constructor for hibernate
    }
    public String getPurchaseId() {
        return purchaseId;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public String getProductId() {
        return productId;
    }

    public int getNumberReceived() {
        return numberReceived;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    @Override
    public Purchase translatePojoToPersistent(PurchasesPOJO objectPojo) {
        this.numberReceived=objectPojo.getNumberReceived();
        this.productId=objectPojo.getProductId();
        this.purchaseDate=objectPojo.getPurchaseDate();
        this.supplierId=objectPojo.getSupplierId();
        this.purchaseId =objectPojo.getPurchasesId();
        return this;
    }
}
