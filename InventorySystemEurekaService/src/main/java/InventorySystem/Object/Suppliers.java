package inventorysystem.object;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Suppliers {
    @Id
    @GeneratedValue
    private Long supplierId;
    private String supplier;


    public Suppliers(){
        //Default constructor for hibernate
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) { this.supplier = supplier; }
}
