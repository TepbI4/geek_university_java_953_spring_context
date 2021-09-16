BEGIN;

DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products (id bigserial PRIMARY KEY, title VARCHAR(255), price numeric(6, 2));
INSERT INTO products (title, price) VALUES
('Bread', 40),
('Milk', 80),
('Cheese', 150),
('Sausage', 250),
('Cookies', 90),
('Tea', 200),
('Yogurt', 45),
('Salmon', 500),
('Sugar', 70),
('Salt', 99);

DROP TABLE IF EXISTS clients CASCADE;
CREATE TABLE clients (id bigserial PRIMARY KEY, name VARCHAR(255));
INSERT INTO clients (name) VALUES
('John'),
('Jack'),
('Alice'),
('Kate');

DROP TABLE IF EXISTS clients_orders CASCADE;
CREATE TABLE clients_orders (client_id bigint, product_id bigint, FOREIGN KEY (client_id) REFERENCES clients (id), FOREIGN KEY (product_id) REFERENCES products (id));
INSERT INTO clients_orders (client_id, product_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(1, 5),
(2, 6),
(3, 7),
(4, 7),
(1, 8),
(2, 8);

COMMIT;