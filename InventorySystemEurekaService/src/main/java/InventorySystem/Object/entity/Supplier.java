package inventorysystem.object.entity;

import inventorysystem.object.PersistentObject;
import inventorysystem.object.pojo.SupplierPOJO;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@EqualsAndHashCode
@Table(name = "Supplier_table")
public class Supplier implements PersistentObject<Supplier, SupplierPOJO>, Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue
    private Long Id;
    @Column(name = "supplierId",unique = true)
    private String supplierId;
    @Column(name = "supplier")
    private String supplier;

    public Supplier(){
        //Default constructor for hibernate
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) { this.supplier = supplier; }


    public Supplier translatePojoToPersistent(SupplierPOJO objectPojo) {
        this.supplierId =objectPojo.getSupplierId();
        this.supplier=objectPojo.getSupplier();
        return this;
    }
}
