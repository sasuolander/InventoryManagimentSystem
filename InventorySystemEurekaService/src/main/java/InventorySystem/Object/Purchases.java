package inventorysystem.object;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Purchases implements PersistentObject<Purchases,PurchasesPOJO>  {
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
