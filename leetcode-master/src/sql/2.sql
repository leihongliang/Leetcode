drop table if exists customers;
-- 创建 customers 表
CREATE TABLE customers (
                           customer_id INT PRIMARY KEY,
                           customer_name VARCHAR(50)
);

drop table if exists products;
-- 创建 products 表
CREATE TABLE products (
                          product_id INT PRIMARY KEY,
                          product_name VARCHAR(50)
);

drop table if exists orders;
-- 创建 orders 表
CREATE TABLE orders (
                        order_id INT PRIMARY KEY,
                        customer_id INT,
                        product_id INT,
                        order_date DATE
);


-- 插入 customers 表数据
INSERT INTO customers (customer_id, customer_name)
VALUES
    (1, 'Alice'),
    (2, 'Bob'),
    (3, 'Charlie');

-- 插入 products 表数据
INSERT INTO sqlexe.products (product_id, product_name)
VALUES
    (1, 'iPhone'),
    (2, 'iPad'),
    (3, 'MacBook');

-- 插入 orders 表数据
INSERT INTO sqlexe.orders (order_id, customer_id, product_id, order_date)
VALUES
    (1, 1, 1, '2022-01-01'),
    (2, 1, 2, '2022-01-02'),
    (3, 2, 1, '2022-02-01'),
    (4, 2, 3, '2022-02-02'),
    (5, 3, 2, '2022-03-01');

SELECT c.customer_id, c.customer_name, p.product_name
FROM customers c
         JOIN (
    SELECT o.customer_id, p.product_name,
           ROW_NUMBER() OVER (PARTITION BY o.customer_id ORDER BY o.order_date DESC) AS rn
    FROM orders o
             JOIN products p ON o.product_id = p.product_id
) p ON c.customer_id = p.customer_id AND p.rn = 1
ORDER BY c.customer_id;