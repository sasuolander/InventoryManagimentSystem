create sequence hibernate_sequence start with 1 increment by 1
create table order_table (id bigint not null, first_name varchar(255), last_name varchar(255), number_shipped integer not null, order_date timestamp, order_id bigint, title varchar(255), primary key (id))
create table product_table (id bigint not null, inventory_on_hand integer, minimum_required integer, part_number integer, product_id bigint, product_label varchar(255), product_number integer, starting_inventory integer, order_id bigint, primary key (id))
create table purchase_table (id bigint not null, number_received integer, product_id bigint, purchase_date timestamp, purchase_id bigint, supplier_id bigint, primary key (id))
create table supplier_table (id bigint not null, supplier varchar(255), supplier_id bigint, primary key (id))
alter table product_table add constraint FKe3y4av8eapktycpbuagx3lcgl foreign key (order_id) references order_table
create sequence hibernate_sequence start with 1 increment by 1
create table order_table (id bigint not null, first_name varchar(255), last_name varchar(255), number_shipped integer not null, order_date timestamp, order_id bigint, title varchar(255), primary key (id))
create table product_table (id bigint not null, inventory_on_hand integer, minimum_required integer, part_number integer, product_id bigint, product_label varchar(255), product_number integer, starting_inventory integer, order_id bigint, primary key (id))
create table purchase_table (id bigint not null, number_received integer, product_id bigint, purchase_date timestamp, purchase_id bigint, supplier_id bigint, primary key (id))
create table supplier_table (id bigint not null, supplier varchar(255), supplier_id bigint, primary key (id))
alter table product_table add constraint FKe3y4av8eapktycpbuagx3lcgl foreign key (order_id) references order_table
