-- =================================================================
-- Populating the 'category' table
-- Using the 'category_seq' sequence to generate primary keys
-- =================================================================

INSERT INTO category (id, name, description) VALUES
    (nextval('category_seq'), 'Electronics', 'Devices and gadgets powered by electricity.'),
    (nextval('category_seq'), 'Books', 'Printed and digital books across all genres.'),
    (nextval('category_seq'), 'Apparel', 'Clothing, footwear, and accessories for all ages.'),
    (nextval('category_seq'), 'Home & Kitchen', 'Appliances, cookware, and essentials for your home.'),
    (nextval('category_seq'), 'Sports & Outdoors', 'Gear and equipment for sports, fitness, and outdoor activities.');


-- =================================================================
-- Populating the 'product' table
-- Using the 'product_seq' sequence for primary keys and referencing
-- the category IDs created above.
-- Using subqueries to fetch category_id is a robust practice
-- that prevents issues if the insertion order changes.
-- =================================================================

-- Products for 'Electronics'
INSERT INTO product (id, name, description, available_quantity, price, category_id) VALUES
    (nextval('product_seq'), 'Laptop Pro 15"', 'High-performance laptop for professionals.', 150, 1999.99, (SELECT id FROM category WHERE name = 'Electronics')),
    (nextval('product_seq'), 'Smartphone X', 'The latest generation of our flagship smartphone.', 300, 999.50, (SELECT id FROM category WHERE name = 'Electronics')),
    (nextval('product_seq'), 'Noise-Cancelling Headphones', 'Immersive sound experience with active noise cancellation.', 500, 249.00, (SELECT id FROM category WHERE name = 'Electronics')),
    (nextval('product_seq'), '4K Ultra HD Monitor', '27-inch monitor with stunning 4K resolution and vibrant colors.', 220, 449.99, (SELECT id FROM category WHERE name = 'Electronics')),
    (nextval('product_seq'), 'Wireless Mechanical Keyboard', 'A tactile and responsive keyboard for coders and gamers.', 300, 189.50, (SELECT id FROM category WHERE name = 'Electronics'));

-- Products for 'Books'
INSERT INTO product (id, name, description, available_quantity, price, category_id) VALUES
    (nextval('product_seq'), 'The Art of Code', 'A deep dive into writing clean and efficient code.', 1200, 45.50, (SELECT id FROM category WHERE name = 'Books')),
    (nextval('product_seq'), 'Dune', 'Classic science fiction novel by Frank Herbert.', 2500, 15.99, (SELECT id FROM category WHERE name = 'Books')),
    (nextval('product_seq'), 'Designing Data-Intensive Applications', 'The big ideas behind reliable, scalable, and maintainable systems.', 800, 59.99, (SELECT id FROM category WHERE name = 'Books')),
    (nextval('product_seq'), 'A Brief History of Time', 'From the Big Bang to Black Holes by Stephen Hawking.', 1500, 14.99, (SELECT id FROM category WHERE name = 'Books'));

-- Products for 'Apparel'
INSERT INTO product (id, name, description, available_quantity, price, category_id) VALUES
    (nextval('product_seq'), 'Classic Cotton T-Shirt', 'A comfortable and durable 100% cotton t-shirt.', 10000, 25.00, (SELECT id FROM category WHERE name = 'Apparel')),
    (nextval('product_seq'), 'Slim-Fit Denim Jeans', 'Modern slim-fit jeans made with stretch denim.', 450, 75.99, (SELECT id FROM category WHERE name = 'Apparel')),
    (nextval('product_seq'), 'All-Weather Running Jacket', 'Lightweight, waterproof, and breathable jacket for all conditions.', 600, 110.00, (SELECT id FROM category WHERE name = 'Apparel')),
    (nextval('product_seq'), 'Leather Ankle Boots', 'Stylish and durable boots crafted from genuine leather.', 320, 145.50, (SELECT id FROM category WHERE name = 'Apparel'));

-- Products for 'Home & Kitchen'
INSERT INTO product (id, name, description, available_quantity, price, category_id) VALUES
    (nextval('product_seq'), '12-Cup Coffee Maker', 'Programmable coffee maker with auto-shutoff.', 350, 89.99, (SELECT id FROM category WHERE name = 'Home & Kitchen')),
    (nextval('product_seq'), 'High-Speed Blender', 'Powerful blender for smoothies, soups, and more.', 200, 120.00, (SELECT id FROM category WHERE name = 'Home & Kitchen')),
    (nextval('product_seq'), 'Robotic Vacuum Cleaner', 'Smart vacuum with mapping technology for automated cleaning.', 180, 399.99, (SELECT id FROM category WHERE name = 'Home & Kitchen')),
    (nextval('product_seq'), 'Cast Iron Skillet', '12-inch pre-seasoned skillet for superior heat retention.', 900, 35.00, (SELECT id FROM category WHERE name = 'Home & Kitchen'));

-- Products for 'Sports & Outdoors'
INSERT INTO product (id, name, description, available_quantity, price, category_id) VALUES
    (nextval('product_seq'), 'Yoga Mat', 'Extra-thick, non-slip mat for yoga and pilates.', 1500, 29.95, (SELECT id FROM category WHERE name = 'Sports & Outdoors')),
    (nextval('product_seq'), 'Adjustable Dumbbells Set', 'Space-saving dumbbell set, adjustable from 5 to 52.5 lbs.', 150, 349.00, (SELECT id FROM category WHERE name = 'Sports & Outdoors')),
    (nextval('product_seq'), '2-Person Camping Tent', 'Waterproof and easy-to-assemble tent for backpacking.', 400, 95.00, (SELECT id FROM category WHERE name = 'Sports & Outdoors')),
    (nextval('product_seq'), 'Insulated Water Bottle', '24oz stainless steel bottle that keeps drinks cold for 24 hours.', 2000, 22.50, (SELECT id FROM category WHERE name = 'Sports & Outdoors'))