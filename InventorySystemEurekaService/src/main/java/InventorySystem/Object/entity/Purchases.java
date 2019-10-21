package inventorysystem.object.entity;

import inventorysystem.object.PersistentObject;
import inventorysystem.object.pojo.PurchasesPOJO;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
@EqualsAndHashCode
public class Purchases implements PersistentObject<Purchases, PurchasesPOJO>, Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue
    private  Long purchasesId;
    private  Long supplierId;
    private  Long productId;
    private  int numberReceived;
    private  Date purchaseDate;

    //Default constructor
    public Purchases(){
        //Default constructor for hibernate
    }
    public Long getPurchasesId() {
        return purchasesId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public Long getProductId() {
        return productId;
    }

    public int getNumberReceived() {
        return numberReceived;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    @Override
    public Purchases translatePojoToPersistent(PurchasesPOJO objectPojo) {
        this.numberReceived=objectPojo.getNumberReceived();
        this.productId=objectPojo.getProductId();
        this.purchaseDate=objectPojo.getPurchaseDate();
        this.supplierId=objectPojo.getSupplierId();
        this.purchasesId=objectPojo.getPurchasesId();
        return this;
    }
}
