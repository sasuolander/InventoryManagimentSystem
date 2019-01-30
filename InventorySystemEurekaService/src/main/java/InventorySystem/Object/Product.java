package InventorySystem.Object;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private final Long product_id;
    private final int product_number;
    private final int part_number;
    private final String product_label;
    private final int starting_inventory;
    private final int inventory_on_hand;
    private final int minimum_required;

    private Product(Builder builder) {
        product_id = builder.product_id;
        product_number = builder.product_number;
        part_number = builder.part_number;
        product_label = builder.product_label;
        starting_inventory = builder.starting_inventory;
        inventory_on_hand = builder.inventory_on_hand;
        minimum_required = builder.minimum_required;
    }


    public static final class Builder {
        private final Long product_id;
        private int product_number;
        private int part_number;
        private String product_label;
        private int starting_inventory;
        private int inventory_on_hand;
        private int minimum_required;

        public Builder(Long product_id) {
            this.product_id = product_id;
        }

        public Builder setProduct_number(int val) {
            product_number = val;
            return this;
        }

        public Builder setPart_number(int val) {
            part_number = val;
            return this;
        }

        public Builder setProduct_label(String val) {
            product_label = val;
            return this;
        }

        public Builder setStarting_inventory(int val) {
            starting_inventory = val;
            return this;
        }

        public Builder setInventory_on_hand(int val) {
            inventory_on_hand = val;
            return this;
        }

        public Builder setMinimum_required(int val) {
            minimum_required = val;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }
}
