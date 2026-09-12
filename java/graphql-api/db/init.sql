CREATE SCHEMA IF NOT EXISTS "customer";
CREATE SCHEMA IF NOT EXISTS "order";
CREATE SCHEMA IF NOT EXISTS "payment";
CREATE SCHEMA IF NOT EXISTS "product";

CREATE TABLE customer.customers (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(150) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

CREATE TABLE product.products (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(200) NOT NULL,
    description TEXT,
    price NUMERIC(12, 2) NOT NULL CHECK (price >= 0),
    image_url TEXT,
    stock INTEGER NOT NULL DEFAULT 0 CHECK (stock >= 0),
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

CREATE TABLE "order".orders (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    customer_id UUID NOT NULL,
    status VARCHAR(30) NOT NULL DEFAULT 'PENDING',
    total NUMERIC(12, 2) NOT NULL DEFAULT 0
        CHECK (total >= 0),
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    CONSTRAINT orders_status_check
        CHECK (status IN (
            'PENDING',
            'CONFIRMED',
            'PROCESSING',
            'SHIPPED',
            'DELIVERED',
            'CANCELLED'
        ))
);

CREATE TABLE "order".order_items (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    order_id UUID NOT NULL,
    product_id UUID NOT NULL,
    quantity INTEGER NOT NULL CHECK (quantity > 0),
    unit_price NUMERIC(12, 2) NOT NULL
        CHECK (unit_price >= 0),
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_order_items_order
        FOREIGN KEY (order_id)
        REFERENCES "order".orders(id)
        ON DELETE CASCADE
);

CREATE TABLE payment.payments (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    order_id UUID NOT NULL UNIQUE,
    amount NUMERIC(12, 2) NOT NULL
        CHECK (amount >= 0),
    status VARCHAR(30) NOT NULL DEFAULT 'PENDING',
    paid_at TIMESTAMPTZ,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    CONSTRAINT payments_status_check
        CHECK (status IN (
            'PENDING',
            'AUTHORIZED',
            'PAID',
            'FAILED',
            'REFUNDED'
        ))
);

CREATE INDEX idx_orders_customer_id ON "order".orders(customer_id);
CREATE INDEX idx_orders_created_at ON "order".orders(created_at DESC);
CREATE INDEX idx_order_items_order_id ON "order".order_items(order_id);
CREATE INDEX idx_order_items_product_id ON "order".order_items(product_id);
CREATE INDEX idx_payments_order_id ON payment.payments(order_id);
CREATE INDEX idx_products_name ON product.products(name);

INSERT INTO customer.customers (name, email) VALUES
    ('Alice Silva', 'alice@example.com'),
    ('Bob Santos', 'bob@example.com'),
    ('Carlos Oliveira', 'carlos@example.com'),
    ('Daniel Costa', 'daniel@example.com'),
    ('Eduardo Martins', 'eduardo@example.com'),
    ('Fernanda Lima', 'fernanda@example.com'),
    ('Gabriel Rocha', 'gabriel@example.com'),
    ('Helena Souza', 'helena@example.com'),
    ('Isabela Mendes', 'isabela@example.com'),
    ('João Pereira', 'joao@example.com');

INSERT INTO product.products (name, description, price, image_url, stock) VALUES
    (
        'Mechanical Keyboard',
        'RGB mechanical keyboard',
        499.90,
        'https://example.com/keyboard.jpg',
        50
    ),
    (
        'Gaming Mouse',
        'High precision gaming mouse',
        249.90,
        'https://example.com/mouse.jpg',
        100
    ),
    (
        'Gaming Headset',
        '7.1 surround gaming headset',
        399.90,
        'https://example.com/headset.jpg',
        30
    ),
    (
        'Gaming Monitor 27"',
        '27 inch 144Hz gaming monitor',
        1899.90,
        'https://example.com/monitor.jpg',
        20
    ),
    (
        'Webcam Full HD',
        '1080p USB webcam',
        299.90,
        'https://example.com/webcam.jpg',
        40
    );

INSERT INTO "order".orders (customer_id, status, total, created_at, updated_at) VALUES
    ((SELECT id FROM customer.customers WHERE email = 'alice@example.com'),
        'DELIVERED', 999.70, NOW() - INTERVAL '15 days', NOW() - INTERVAL '10 days'),
    ((SELECT id FROM customer.customers WHERE email = 'bob@example.com'),
        'PENDING', 399.90, NOW() - INTERVAL '2 days', NOW() - INTERVAL '2 days'),
    ((SELECT id FROM customer.customers WHERE email = 'carlos@example.com'),
        'SHIPPED', 2199.80, NOW() - INTERVAL '7 days', NOW() - INTERVAL '1 day'),
    ((SELECT id FROM customer.customers WHERE email = 'fernanda@example.com'),
        'CANCELLED', 999.80, NOW() - INTERVAL '12 days', NOW() - INTERVAL '11 days'),
    ((SELECT id FROM customer.customers WHERE email = 'joao@example.com'),
        'PROCESSING', 849.70, NOW() - INTERVAL '3 days', NOW() - INTERVAL '1 day');

INSERT INTO "order".order_items (order_id, product_id, quantity, unit_price, created_at) VALUES
    ((SELECT o.id FROM "order".orders o JOIN customer.customers c ON c.id = o.customer_id
        WHERE c.email = 'alice@example.com'),
        (SELECT id FROM product.products WHERE name = 'Mechanical Keyboard'),
        1, 499.90, NOW() - INTERVAL '15 days'),
    ((SELECT o.id FROM "order".orders o JOIN customer.customers c ON c.id = o.customer_id
        WHERE c.email = 'alice@example.com'),
        (SELECT id FROM product.products WHERE name = 'Gaming Mouse'),
        2, 249.90, NOW() - INTERVAL '15 days'),
    ((SELECT o.id FROM "order".orders o JOIN customer.customers c ON c.id = o.customer_id
        WHERE c.email = 'bob@example.com'),
        (SELECT id FROM product.products WHERE name = 'Gaming Headset'),
        1, 399.90, NOW() - INTERVAL '2 days'),
    ((SELECT o.id FROM "order".orders o JOIN customer.customers c ON c.id = o.customer_id
        WHERE c.email = 'carlos@example.com'),
        (SELECT id FROM product.products WHERE name = 'Gaming Monitor 27"'),
        1, 1899.90, NOW() - INTERVAL '7 days'),
    ((SELECT o.id FROM "order".orders o JOIN customer.customers c ON c.id = o.customer_id
        WHERE c.email = 'carlos@example.com'),
        (SELECT id FROM product.products WHERE name = 'Webcam Full HD'),
        1, 299.90, NOW() - INTERVAL '7 days'),
    ((SELECT o.id FROM "order".orders o JOIN customer.customers c ON c.id = o.customer_id
        WHERE c.email = 'fernanda@example.com'),
        (SELECT id FROM product.products WHERE name = 'Mechanical Keyboard'),
        2, 499.90, NOW() - INTERVAL '12 days'),
    ((SELECT o.id FROM "order".orders o JOIN customer.customers c ON c.id = o.customer_id
        WHERE c.email = 'joao@example.com'),
        (SELECT id FROM product.products WHERE name = 'Webcam Full HD'),
        2, 299.90, NOW() - INTERVAL '3 days'),
    ((SELECT o.id FROM "order".orders o JOIN customer.customers c ON c.id = o.customer_id
        WHERE c.email = 'joao@example.com'),
        (SELECT id FROM product.products WHERE name = 'Gaming Mouse'),
        1, 249.90, NOW() - INTERVAL '3 days');

INSERT INTO payment.payments (order_id, amount, status, paid_at, created_at, updated_at) VALUES
    ((SELECT o.id FROM "order".orders o JOIN customer.customers c ON c.id = o.customer_id
        WHERE c.email = 'alice@example.com'),
        999.70, 'PAID', NOW() - INTERVAL '14 days',
        NOW() - INTERVAL '15 days', NOW() - INTERVAL '14 days'),
    ((SELECT o.id FROM "order".orders o JOIN customer.customers c ON c.id = o.customer_id
        WHERE c.email = 'bob@example.com'),
        399.90, 'PENDING', NULL,
        NOW() - INTERVAL '2 days', NOW() - INTERVAL '2 days'),
    ((SELECT o.id FROM "order".orders o JOIN customer.customers c ON c.id = o.customer_id
        WHERE c.email = 'carlos@example.com'),
        2199.80, 'PAID', NOW() - INTERVAL '6 days',
        NOW() - INTERVAL '7 days', NOW() - INTERVAL '6 days'),
    ((SELECT o.id FROM "order".orders o JOIN customer.customers c ON c.id = o.customer_id
        WHERE c.email = 'fernanda@example.com'),
        999.80, 'REFUNDED', NOW() - INTERVAL '12 days',
        NOW() - INTERVAL '12 days', NOW() - INTERVAL '11 days'),
    ((SELECT o.id FROM "order".orders o JOIN customer.customers c ON c.id = o.customer_id
        WHERE c.email = 'joao@example.com'),
        849.70, 'AUTHORIZED', NULL,
        NOW() - INTERVAL '3 days', NOW() - INTERVAL '1 day');
