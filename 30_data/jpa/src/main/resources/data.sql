INSERT INTO customers (id, first_name, last_name, email) VALUES
(1, 'John', 'Doe', 'john.doe@example.com'),
(2, 'Jane', 'Smith', 'jane.smith@example.com'),
(3, 'Bob', 'Johnson', 'bob.johnson@example.com');

INSERT INTO products (id, name, price) VALUES
(1, 'Laptop', 1200.00),
(2, 'Smartphone', 800.00),
(3, 'Headphones', 150.00);

INSERT INTO orders (id, customer_id) VALUES
(1, 1),
(2, 2),
(3, 1);

INSERT INTO order_products (order_id, product_id) VALUES
(1, 1),
(1, 2),
(2, 3),
(3, 1),
(3, 2);
