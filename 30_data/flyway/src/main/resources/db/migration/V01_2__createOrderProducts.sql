CREATE TABLE order_products (
  order_id BIGINT NOT NULL,
  product_id BIGINT NOT NULL,
  PRIMARY KEY (order_id, product_id)
)
