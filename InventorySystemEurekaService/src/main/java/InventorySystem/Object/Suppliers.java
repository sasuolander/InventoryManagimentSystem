package InventorySystem.Object;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Suppliers {
    @Id
    @GeneratedValue
    private Long supplier_id;
    private String supplier;

    public Long getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(Long supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) { this.supplier = supplier; }





}
