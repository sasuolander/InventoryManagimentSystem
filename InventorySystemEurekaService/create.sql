create sequence hibernate_sequence start with 1 increment by 1
create table order_table (order_id bigint not null, first_name varchar(255), last_name varchar(255), number_shipped integer not null, order_date timestamp, title varchar(255), primary key (order_id))
create table order_table_product_list (order_order_id bigint not null, product_list_product_id bigint not null)
create table product (product_id bigint not null, inventory_on_hand integer not null, minimum_required integer not null, part_number integer not null, product_label varchar(255), product_number integer not null, starting_inventory integer not null, product_list_order_id bigint, primary key (product_id))
create table purchases (purchases_id bigint not null, number_received integer not null, product_id bigint, purchase_date timestamp, supplier_id bigint, primary key (purchases_id))
create table suppliers (supplier_id bigint not null, supplier varchar(255), primary key (supplier_id))
alter table order_table_product_list add constraint UK_tixavev831og6ifuvc68sunj1 unique (product_list_product_id)
alter table order_table_product_list add constraint FKd5gyfxc402jrqqprc5f4ylav4 foreign key (product_list_product_id) references product
alter table order_table_product_list add constraint FKk0u3vus4sd7apuwm9jf47eqjf foreign key (order_order_id) references order_table
alter table product add constraint FKjwje11ywyhygixo3r0vwfy0cc foreign key (product_list_order_id) references order_table

