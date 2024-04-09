CREATE TABLE role (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50)
);

CREATE TABLE user_app (
    user_app_id SERIAL PRIMARY KEY,
    login VARCHAR(50),
    email VARCHAR(50),
    password VARCHAR(50),
    role_id INT,
    FOREIGN KEY (role_id) REFERENCES role(id) ON DELETE CASCADE
);

CREATE TABLE address (
    id SERIAL PRIMARY KEY,
    city VARCHAR(100),
    street VARCHAR(100),
    house VARCHAR(20),
    flat VARCHAR(10),
    user_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user_app(user_app_id) ON DELETE CASCADE
);

CREATE TABLE supply (
    id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user_app(user_app_id) ON DELETE CASCADE
);

CREATE TABLE bask_shoe (
    id SERIAL PRIMARY KEY,
    title VARCHAR(50),
    description VARCHAR(50),
    price INT NOT NULL,
    manufacturer VARCHAR(50),
    brand VARCHAR(50),
    size INT NOT NULL
);

CREATE TABLE supply_log (
    bask_shoe_id INT NOT NULL,
    supply_id INT NOT NULL,
    PRIMARY KEY (bask_shoe_id, supply_id),
    FOREIGN KEY (bask_shoe_id) REFERENCES bask_shoe(id) ON DELETE CASCADE,
    FOREIGN KEY (supply_id) REFERENCES supply(id) ON DELETE CASCADE
);

CREATE TABLE bask_shop(
    id SERIAL PRIMARY KEY,
    title VARCHAR(50),
    rating INT CHECK (rating >= 0 AND rating <= 11),
    user_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user_app(user_app_id) ON DELETE CASCADE
);

CREATE TABLE catalog_shoes (
    bask_shoe_id INT NOT NULL,
    shop_id INT NOT NULL,
    PRIMARY KEY (bask_shoe_id, shop_id),
    FOREIGN KEY (bask_shoe_id) REFERENCES bask_shoe(id) ON DELETE CASCADE,
    FOREIGN KEY (shop_id) REFERENCES bask_shop(id) ON DELETE CASCADE
);

CREATE TABLE shopping_cart(
    id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user_app(user_app_id) ON DELETE CASCADE
);

CREATE TABLE bask_cart (
    bask_shoe_id INT NOT NULL,
    shopping_cart_id INT NOT NULL,
    PRIMARY KEY (bask_shoe_id, shopping_cart_id),
    FOREIGN KEY (bask_shoe_id) REFERENCES bask_shoe(id) ON DELETE CASCADE,
    FOREIGN KEY (shopping_cart_id) REFERENCES shopping_cart(id) ON DELETE CASCADE
);

CREATE TABLE order_app (
    id SERIAL PRIMARY KEY,
    shopping_cart_id INT NOT NULL,
    shop_id INT NOT NULL,
    status_name VARCHAR(50),
    FOREIGN KEY (shopping_cart_id) REFERENCES shopping_cart(id) ON DELETE CASCADE,
    FOREIGN KEY (shop_id) REFERENCES bask_shop(id) ON DELETE CASCADE
);



