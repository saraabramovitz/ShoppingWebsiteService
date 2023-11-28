DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS item;
DROP TABLE IF EXISTS user_order;
DROP TABLE IF EXISTS order_item;
DROP TABLE IF EXISTS favorite;

CREATE TABLE user (
     user_id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
     first_name VARCHAR(255) NOT NULL DEFAULT '',
     last_name VARCHAR(255) NOT NULL DEFAULT '',
     email VARCHAR(255) NOT NULL DEFAULT '',
     phone VARCHAR(255) NOT NULL DEFAULT '',
     address VARCHAR(255) NOT NULL DEFAULT '',
     username VARCHAR(255) NOT NULL DEFAULT '',
     password VARCHAR(255) NOT NULL DEFAULT '',
     PRIMARY KEY (user_id)
);

CREATE TABLE item (
     item_id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
     item_name VARCHAR(255) NOT NULL DEFAULT '',
     item_image VARCHAR(255) NOT NULL DEFAULT '',
     price DECIMAL(10, 2) NOT NULL DEFAULT 0,
     stock INT(11) NOT NULL DEFAULT 0,
     PRIMARY KEY (item_id)
);

CREATE TABLE user_order (
     user_order_id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
     user_id INT(11) NOT NULL,
     shipping_address VARCHAR(255) DEFAULT '',
     order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
     status VARCHAR(255) DEFAULT 'TEMP',
     PRIMARY KEY (user_order_id),
     FOREIGN KEY (user_id) REFERENCES user(user_id)
);

CREATE TABLE order_item (
    order_item_id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
    user_order_id INT(11) NOT NULL,
    item_id INT(11) NOT NULL,
    quantity INT(11) NOT NULL DEFAULT 1,
    PRIMARY KEY (order_item_id),
    FOREIGN KEY (user_order_id) REFERENCES user_order(user_order_id),
    FOREIGN KEY (item_id) REFERENCES item(item_id)
);

CREATE TABLE favorite_item (
     favorite_item_id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
     user_id INT(11) NOT NULL,
     item_id INT(11) NOT NULL UNIQUE,
     PRIMARY KEY (favorite_item_id),
     FOREIGN KEY (user_id) REFERENCES user(user_id),
     FOREIGN KEY (item_id) REFERENCES item(item_id)
);

INSERT INTO item (item_name, item_image, price, stock) VALUES
    ('jbl', 'url/jbl', 500.80, 70),
    ('headphones', 'url/headphones', 250.00, 300),
    ('computer screen', 'url/computerScreen', 1300.50, 150),
    ('speaker', 'url/speaker', 735.70, 120),
    ('computer monitor', 'url/computerMonitor', 2545.00, 322);
