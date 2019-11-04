package inventorysystem.object.pojo;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

@EqualsAndHashCode
@ToString
@Builder(builderClassName = "Builder")
public class PurchasesPOJO {
    private  String purchasesId;
    private  String supplierId;
    private  String productId;
    private  int numberReceived;
    private  Date purchaseDate;

    public String getPurchasesId() {
        return purchasesId;
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

}
