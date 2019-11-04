package inventorysystem.object.pojo;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Builder(builderClassName = "Builder")
public class SuppliersPOJO {
    private String supplierId;
    private String supplier;

    public String getSupplierId() {
        return supplierId;
    }
    public String getSupplier() {
        return supplier;
    }
}
