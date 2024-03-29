CREATE TABLE user_app (
    user_app_id SERIAL PRIMARY KEY,
    login VARCHAR(50),
    email VARCHAR(50),
    password VARCHAR(50)
);

CREATE TABLE address (
    id SERIAL PRIMARY KEY,
    city VARCHAR(100),
    street VARCHAR(100),
    house VARCHAR(20),
    flat VARCHAR(10)
);

CREATE TABLE customer (
    id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    address_id INT NOT NULL,
    money_user INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user_app(user_app_id),
    FOREIGN KEY (address_id) REFERENCES address(id)
);

CREATE TABLE provider (
    id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user_app(user_app_id)
);

CREATE TABLE supply (
    id SERIAL PRIMARY KEY,
    provider_id INT NOT NULL,
    data TIMESTAMP,
    FOREIGN KEY (provider_id) REFERENCES provider(id)
);

CREATE TABLE bask_shoe (
    id SERIAL PRIMARY KEY,
    title VARCHAR(50),
    description VARCHAR(50),
    price MONEY,
    manufacturer VARCHAR(50),
    brand VARCHAR(50),
    size INT NOT NULL
);

CREATE TABLE supply_log (
    bask_shoe_id INT NOT NULL,
    supply_id INT NOT NULL,
    PRIMARY KEY (bask_shoe_id, supply_id),
    FOREIGN KEY (bask_shoe_id) REFERENCES bask_shoe(id),
    FOREIGN KEY (supply_id) REFERENCES supply(id)
);

CREATE TABLE bask_shop(
    id SERIAL PRIMARY KEY,
    title VARCHAR(50),
    rating INT CHECK (rating >= 0 AND rating <= 11)
);

CREATE TABLE catalog_products (
    bask_shoe_id INT NOT NULL,
    shop_id INT NOT NULL,
    PRIMARY KEY (bask_shoe_id, shop_id),
    FOREIGN KEY (bask_shoe_id) REFERENCES bask_shoe(id),
    FOREIGN KEY (shop_id) REFERENCES bask_shop(id)
);

CREATE TABLE admin_shop(
    id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    shop_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user_app(user_app_id),
    FOREIGN KEY (shop_id) REFERENCES bask_shop(id)
);

CREATE TABLE shopping_cart(
    id SERIAL PRIMARY KEY,
    customer_id INT NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);

CREATE TABLE bask_cart (
    bask_shoe_id INT NOT NULL,
    shopping_cart_id INT NOT NULL,
    PRIMARY KEY (bask_shoe_id, shopping_cart_id),
    FOREIGN KEY (bask_shoe_id) REFERENCES bask_shoe(id),
    FOREIGN KEY (shopping_cart_id) REFERENCES shopping_cart(id)
);

CREATE TABLE order_app (
    id SERIAL PRIMARY KEY,
    shopping_cart_id INT NOT NULL,
    shop_id INT NOT NULL,
    status_name VARCHAR(50),
    FOREIGN KEY (shopping_cart_id) REFERENCES shopping_cart(id),
    FOREIGN KEY (shop_id) REFERENCES bask_shop(id)
);



