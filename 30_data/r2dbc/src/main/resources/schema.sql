create table customers (id bigint generated by default as identity, email varchar(255), first_name varchar(255), last_name varchar(255), primary key (id))

create table order_products (order_id bigint not null, product_id bigint not null)

create table orders (customer_id bigint, id bigint generated by default as identity, primary key (id))

create table products (price float(53) not null, id bigint generated by default as identity, name varchar(255), primary key (id))

alter table if exists order_products add constraint order_products_product_id foreign key (product_id) references products

alter table if exists order_products add constraint order_products_order_id foreign key (order_id) references orders

alter table if exists orders add constraint order_customer_id foreign key (customer_id) references customers
