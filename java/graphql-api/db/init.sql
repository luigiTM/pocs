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

INSERT INTO customer.customers (id, name, email) VALUES
    ('10000000-0000-0000-0000-000000000001', 'Alice Silva', 'alice@example.com'),
    ('10000000-0000-0000-0000-000000000002', 'Bob Santos', 'bob@example.com'),
    ('10000000-0000-0000-0000-000000000003', 'Carlos Oliveira', 'carlos@example.com'),
    ('10000000-0000-0000-0000-000000000004', 'Daniel Costa', 'daniel@example.com'),
    ('10000000-0000-0000-0000-000000000005', 'Eduardo Martins', 'eduardo@example.com'),
    ('10000000-0000-0000-0000-000000000006', 'Fernanda Lima', 'fernanda@example.com'),
    ('10000000-0000-0000-0000-000000000007', 'Gabriel Rocha', 'gabriel@example.com'),
    ('10000000-0000-0000-0000-000000000008', 'Helena Souza', 'helena@example.com'),
    ('10000000-0000-0000-0000-000000000009', 'Isabela Mendes', 'isabela@example.com'),
    ('10000000-0000-0000-0000-000000000010', 'João Pereira', 'joao@example.com');

INSERT INTO product.products (id, name, description, price, image_url, stock) VALUES
    (
        '20000000-0000-0000-0000-000000000001',
        'Mechanical Keyboard',
        'RGB mechanical keyboard',
        499.90,
        'https://example.com/keyboard.jpg',
        50
    ),
    (
        '20000000-0000-0000-0000-000000000002',
        'Gaming Mouse',
        'High precision gaming mouse',
        249.90,
        'https://example.com/mouse.jpg',
        100
    ),
    (
        '20000000-0000-0000-0000-000000000003',
        'Gaming Headset',
        '7.1 surround gaming headset',
        399.90,
        'https://example.com/headset.jpg',
        30
    ),
    (
        '20000000-0000-0000-0000-000000000004',
        'Gaming Monitor 27"',
        '27 inch 144Hz gaming monitor',
        1899.90,
        'https://example.com/monitor.jpg',
        20
    ),
    (
        '20000000-0000-0000-0000-000000000005',
        'Webcam Full HD',
        '1080p USB webcam',
        299.90,
        'https://example.com/webcam.jpg',
        40
    );

INSERT INTO "order".orders (id, customer_id, status, total, created_at, updated_at) VALUES
    ('30000000-0000-0000-0000-000000000001',
        '10000000-0000-0000-0000-000000000001',
        'DELIVERED', 999.70, NOW() - INTERVAL '15 days', NOW() - INTERVAL '10 days'),
    ('30000000-0000-0000-0000-000000000002',
        '10000000-0000-0000-0000-000000000002',
        'PENDING', 399.90, NOW() - INTERVAL '2 days', NOW() - INTERVAL '2 days'),
    ('30000000-0000-0000-0000-000000000003',
        '10000000-0000-0000-0000-000000000003',
        'SHIPPED', 2199.80, NOW() - INTERVAL '7 days', NOW() - INTERVAL '1 day'),
    ('30000000-0000-0000-0000-000000000004',
        '10000000-0000-0000-0000-000000000006',
        'CANCELLED', 999.80, NOW() - INTERVAL '12 days', NOW() - INTERVAL '11 days'),
    ('30000000-0000-0000-0000-000000000005',
        '10000000-0000-0000-0000-000000000010',
        'PROCESSING', 849.70, NOW() - INTERVAL '3 days', NOW() - INTERVAL '1 day');

INSERT INTO "order".order_items (id, order_id, product_id, quantity, unit_price, created_at) VALUES
    ('40000000-0000-0000-0000-000000000001',
        '30000000-0000-0000-0000-000000000001',
        '20000000-0000-0000-0000-000000000001',
        1, 499.90, NOW() - INTERVAL '15 days'),
    ('40000000-0000-0000-0000-000000000002',
        '30000000-0000-0000-0000-000000000001',
        '20000000-0000-0000-0000-000000000002',
        2, 249.90, NOW() - INTERVAL '15 days'),
    ('40000000-0000-0000-0000-000000000003',
        '30000000-0000-0000-0000-000000000002',
        '20000000-0000-0000-0000-000000000003',
        1, 399.90, NOW() - INTERVAL '2 days'),
    ('40000000-0000-0000-0000-000000000004',
        '30000000-0000-0000-0000-000000000003',
        '20000000-0000-0000-0000-000000000004',
        1, 1899.90, NOW() - INTERVAL '7 days'),
    ('40000000-0000-0000-0000-000000000005',
        '30000000-0000-0000-0000-000000000003',
        '20000000-0000-0000-0000-000000000005',
        1, 299.90, NOW() - INTERVAL '7 days'),
    ('40000000-0000-0000-0000-000000000006',
        '30000000-0000-0000-0000-000000000004',
        '20000000-0000-0000-0000-000000000001',
        2, 499.90, NOW() - INTERVAL '12 days'),
    ('40000000-0000-0000-0000-000000000007',
        '30000000-0000-0000-0000-000000000005',
        '20000000-0000-0000-0000-000000000005',
        2, 299.90, NOW() - INTERVAL '3 days'),
    ('40000000-0000-0000-0000-000000000008',
        '30000000-0000-0000-0000-000000000005',
        '20000000-0000-0000-0000-000000000002',
        1, 249.90, NOW() - INTERVAL '3 days');

INSERT INTO payment.payments (id, order_id, amount, status, paid_at, created_at, updated_at) VALUES
    ('50000000-0000-0000-0000-000000000001',
        '30000000-0000-0000-0000-000000000001',
        999.70, 'PAID', NOW() - INTERVAL '14 days',
        NOW() - INTERVAL '15 days', NOW() - INTERVAL '14 days'),
    ('50000000-0000-0000-0000-000000000002',
        '30000000-0000-0000-0000-000000000002',
        399.90, 'PENDING', NULL,
        NOW() - INTERVAL '2 days', NOW() - INTERVAL '2 days'),
    ('50000000-0000-0000-0000-000000000003',
        '30000000-0000-0000-0000-000000000003',
        2199.80, 'PAID', NOW() - INTERVAL '6 days',
        NOW() - INTERVAL '7 days', NOW() - INTERVAL '6 days'),
    ('50000000-0000-0000-0000-000000000004',
        '30000000-0000-0000-0000-000000000004',
        999.80, 'REFUNDED', NOW() - INTERVAL '12 days',
        NOW() - INTERVAL '12 days', NOW() - INTERVAL '11 days'),
    ('50000000-0000-0000-0000-000000000005',
        '30000000-0000-0000-0000-000000000005',
        849.70, 'AUTHORIZED', NULL,
        NOW() - INTERVAL '3 days', NOW() - INTERVAL '1 day');
