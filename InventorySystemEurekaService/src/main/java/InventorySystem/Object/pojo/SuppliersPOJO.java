package inventorysystem.object.pojo;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Builder(builderClassName = "Builder")
public class SuppliersPOJO {
    private Long supplierId;
    private String supplier;

    public Long getSupplierId() {
        return supplierId;
    }
    public String getSupplier() {
        return supplier;
    }
}
