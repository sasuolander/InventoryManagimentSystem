package inventorysystem.object;

public class SuppliersPOJO {

    private Long supplierId;
    private String supplier;

    private SuppliersPOJO(Builder builder) {
        supplierId = builder.supplierId;
        supplier = builder.supplier;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public String getSupplier() {
        return supplier;
    }

    public static final class Builder {
        private Long supplierId;
        private String supplier;

        public Builder() {
        }

        public Builder setSupplierId(Long val) {
            supplierId = val;
            return this;
        }

        public Builder setSupplier(String val) {
            supplier = val;
            return this;
        }

        public SuppliersPOJO build() {
            return new SuppliersPOJO(this);
        }
    }
}
