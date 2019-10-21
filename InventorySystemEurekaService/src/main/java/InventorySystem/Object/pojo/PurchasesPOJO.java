package inventorysystem.object.pojo;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

@EqualsAndHashCode
@ToString
@Builder(builderClassName = "Builder")
public class PurchasesPOJO {
    private  Long purchasesId;
    private  Long supplierId;
    private  Long productId;
    private  int numberReceived;
    private  Date purchaseDate;

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

}
