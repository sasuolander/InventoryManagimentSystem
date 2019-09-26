package inventorysystem.object.entity;

import inventorysystem.object.PersistentObject;
import inventorysystem.object.pojo.SuppliersPOJO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Suppliers implements PersistentObject<Suppliers, SuppliersPOJO> {
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


    public Suppliers translatePojoToPersistent(SuppliersPOJO objectPojo) {
        this.supplierId=objectPojo.getSupplierId();
        this.supplier=objectPojo.getSupplier();
        return this;
    }
}
