CREATE TABLE orders (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY,
  customer_id BIGINT,
  PRIMARY KEY (id)
)
