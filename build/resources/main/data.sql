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
     city VARCHAR(255) NOT NULL DEFAULT '',
     street VARCHAR(255) NOT NULL DEFAULT '',
     buildingNumber INT(11) NOT NULL,
     apartment INT(11),
     username VARCHAR(255) NOT NULL DEFAULT '',
     password VARCHAR(255) NOT NULL DEFAULT '',
     roles VARCHAR(200) NOT NULL DEFAULT '',
     permissions VARCHAR(200) NOT NULL DEFAULT '',
     PRIMARY KEY (user_id)
);


CREATE TABLE item (
    item_id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
    item_name VARCHAR(225) NOT NULL DEFAULT '',
    item_image VARCHAR(255) NOT NULL DEFAULT '',
    item_overview VARCHAR(1000) NOT NULL DEFAULT '',
    item_details VARCHAR(1000) NOT NULL DEFAULT '',
    item_measurements VARCHAR(255) NOT NULL DEFAULT '',
    price DECIMAL(10, 2) NOT NULL DEFAULT 0,
    stock INT(11) NOT NULL DEFAULT 0,
    PRIMARY KEY (item_id)
);


CREATE TABLE user_order (
     user_order_id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
     user_id INT(11) NOT NULL,
     order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
     city VARCHAR(255) NOT NULL DEFAULT '',
     street VARCHAR(255) NOT NULL DEFAULT '',
     buildingNumber INT(11) NOT NULL,
     apartment INT(11),
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
     item_id INT(11) NOT NULL,
     PRIMARY KEY (favorite_item_id),
     FOREIGN KEY (user_id) REFERENCES user(user_id),
     FOREIGN KEY (item_id) REFERENCES item(item_id)
);

INSERT INTO item (item_name, item_image,item_overview, item_details, item_measurements, price, stock) VALUES
        ('Loveseat, Grann / Bomstad black',
        'https://www.ikea.com/us/en/images/products/finnala-loveseat-grann-bomstad-black__0817320_pe773960_s5.jpg?f=xxs',
        'Finnala sectional sofa can grow and change with a home and the family. Choose how many seats, the look and function to create a sofa that suits you. A clean design and long-lasting comfort are included.',
        'This comfortable sofa has pocket spring seat cushions with high resilience foam and a top layer of wadding. It provides a nice comfort and support for your body while maintaining the shape of the seat cushions. The contact surfaces are covered with grann - a soft, smooth and strong grain leather with natural variations. Other surfaces have bomstand, a coated fabric that has a similar look and feel to leather. The sofas sections can be combined in different ways to get a size and shape that suits you. If you need a larger sofa, you can add a section or two.',
        'width: 110 1/4 " Height: 32 5/8 " Min. depth: 37 3/8 " Max. depth: 64 1/8 " Min. seat depth: 23 5/8 " Max. seat depth: 48 7/8 " Seat height: 17 3/4 "',
        1985,
        150),

        ('Sofa with chaise, Kilanda dark blue',
        'https://www.ikea.com/us/en/images/products/uppland-sofa-with-chaise-kilanda-dark-blue__1194860_pe902110_s5.jpg?f=xxs',
        'You know the feeling when you sit, lie down or hang out in a sofa, rather than on it. That''s how embracing the deep and generous Appland sofa is your new favorite place for cozy evenings and lazy days',
        'Enjoy the super comfy Appland sofa with embracing feel and deep seat cushions made of pocket springs, high resilience foam and polyester fibers, adding both firm support and relaxing softness. Reversible back cushions provide soft support for your back and two different sides to wear. Thanks to the combination of polyester fibers and cut foam the cushions will retain their shape and comfort year after year. The cover is easy to keep clean since it is removable and can be machine washed. A range of coordinated covers makes it easy for you to give your furniture a new look.',
        'Width: 101 5/8 " Seat width, chaise lounge: 26 3/4 " Depth: 64 5/8 " Height: 36 1/4 " Seat depth, chaise lounge: 51 1/8 " Height under furniture: 6 3/4 " Armrest height: 26 3/4 " Seat width: 79 7/8 " Seat depth: 22 7/8 " Seat height: 18 1/2 "',
        2990,
        200),

        ('Sectional, 5-seat, with chaise / Grann /wood',
        'https://www.ikea.com/us/en/images/products/morabo-sectional-5-seat-with-chaise-grann-bomstad-gray-green-wood__0816184_pe773137_s5.jpg?f=s',
        'Warm and welcoming, neat and stylish. The supporting seat cushions, the cover''s soft finish and the tight fit gives this sofa a perfect balance between its comfort, functions and look.',
        'Seat cushions filled with high-resilience foam and polyester fiber wadding provide great seating comfort. These wooden legs give Morabo sofa and armchair a warm and natural look. The contact surfaces are covered with grann a soft, smooth and strong grain leather with natural variations. Other surfaces have bomstad, a coated fabric that has a similar look and feel to leather. Removable armrests make it easy to add on a chaise lounge',
        'width: 110 1/4 " Height: 32 5/8 " Min. depth: 37 3/8 " Max. depth: 64 1/8 " Min. seat depth: 23 5/8 " Max. seat depth: 48 7/8 " Seat height: 17 3/4 "',
        4580,
        1500
        ),

        ('Sofa with chaise, Gunnared beige',
        'https://www.ikea.com/il/he/images/products/friheten-three-seat-sofa-bed-skiftebo-dark-grey__0829149_pe644867_s5.jpg?f=xxs',
        'Cuddle up in the comfortable kivik sofa. The generous size, low armrests and pocket springs with foam that adapts to the body invites you and your guests to many hours of socializing and relaxation.',
        'Enjoy the super comfy kivik sofa with deep seat cushions made of pocket springs high resilience foam and polyester fibers adding both firm support and relaxing softness. The size and depth of the sofa make it perfect for a nice nap or when the whole family is gathered. There is room for everyone and even extra seating on the wide armrests. The wide armrests have room for everything from your mobile phone to a bowl of movie snacks and very comfortable to lay your head on when you lie down on the sofa for a rest.',
        'width: 110 1/4 " Height: 32 5/8 " Min. depth: 37 3/8 " Max. depth: 64 1/8 " Min. seat depth: 23 5/8 " Max. seat depth: 48 7/8 " Seat height: 17 3/4 "',
        2100,
        300),

        ('Sofa with chaise, Vissle gray',
        'https://www.ikea.com/us/en/images/products/morabo-loveseat-grann-bomstad-golden-brown-wood__0815920_pe773107_s5.jpg?f=xxs',
        'Warm and welcoming, neat and stylish. The supporting seat cushions, the covers soft finish, the chaise lounge and the tight fit give Morabo sofa a perfect balance of comfort, functionality and look.',
        'Seat cushions filled with high-resilience foam and polyester fiber wadding provide great seating comfort. These wooden legs give Morabo sofa and armchair a warm and natural look. The contact surfaces are covered with grann a soft, smooth and strong grain leather with natural variations. Other surfaces have Bomstand, a coated fabric that has a similar look and feel to leather. Removable armrests make it easy to add on a chaise lounge. 10-year limited warranty. Read about the terms in the limited warranty brochure.',
        'width: 110 1/4 " Height: 32 5/8 " Min. depth: 37 3/8 " Max. depth: 64 1/8 " Min. seat depth: 23 5/8 " Max. seat depth: 48 7/8 " Seat height: 17 3/4 "',
        2355,
        1500
        ),


       ('Loveseat, Grann Bomstad dark beige',
        'https://www.ikea.com/us/en/images/products/morabo-loveseat-grann-bomstad-dark-beige-wood__0834929_pe684290_s5.jpg?f=s',
        'Warm and welcoming, neat and stylish. The supporting seat cushions, the cover''s soft finish and the tight fit gives this sofa a perfect balance between its comfort, functions and look.',
        'Easy to understand and fold out Alvdalen sofa quickly transforms into a comfortable double bed for you or your overnight friends. Or the best place to take a nice nap. You can place the chaise section to the left or right of the sofa, and switch whenever you like. Perfect for smaller spaces with its neat design and the practical and easily accessible storage space under the seat. Plenty of seating space for friends and family. And when the sofa is folded out, you get a large lounge area to hang out on. This cover is made from Knisa fabric in polyester, which is dope-dyed. It''s a durable material which has a soft feel',
        'width: 110 1/4 " Height: 32 5/8 " Min. depth: 37 3/8 " Max. depth: 64 1/8 " Min. seat depth: 23 5/8 " Max. seat depth: 48 7/8 " Seat height: 17 3/4 "',
        1565,
        300),

        ('2.5-seat mod sofa w chaise',
        'https://www.ikea.com/us/en/images/products/jaettebo-2-5-seat-mod-sofa-w-chaise-left-samsala-dark-yellow-green__1139900_pe880552_s5.jpg?f=xxs',
        'Enjoy long movie nights and comfy socializing with friends in Jattebo modular sofa. Use this combination with a relaxing chaise longue as it is - or create a customized sofa for you and your home',
        'The modules can be combined as you like, create a large or small sofa that suits you perfectly - and add more parts when your needs change. Feel free to combine the sofa with more seat and chaise lounge modules, armrests and headrests. Use the planning tool to put the modules together in different ways until the combination feels right. The modules have a soft comfort with high-resilience foam and pocket springs that follow your body and provide support - whether you are sitting, lying down or hanging out on the sofa. The deep and even seats make Jattebo very comfortable to lie on when reading a good book or enjoying a nap',
        'Width: 74 3/4 " Depth: 63 " Height: 28 " Seat depth: 27 1/8 " Seat height: 18 1/8 " Armrest width: 9 7/8 "',
        1699,
        400),

        ('SLoveseat, Grann Bomstad gray-green / wood',
        'https://www.ikea.com/us/en/images/products/morabo-loveseat-grann-bomstad-gray-green-wood__0815922_pe773109_s5.jpg?f=xxs',
        'Warm and welcoming, neat and stylish. The supporting seat cushions, the cover''s soft finish and the tight fit gives this sofa a perfect balance between its comfort, functions and look.',
        'Enjoy the super comfy kivik sofa with deep seat cushions made of pocket springs high resilience foam and polyester fibers adding both firm support and relaxing softness. The size and depth of the sofa make it perfect for a nice nap or when the whole family is gathered. There is room for everyone and even extra seating on the wide armrests. The wide armrests have room for everything from your mobile phone to a bowl of movie snacks and very comfortable to lay your head on when you lie down on the sofa for a rest.',
        'width: 110 1/4 " Height: 32 5/8 " Min. depth: 37 3/8 " Max. depth: 64 1/8 " Min. seat depth: 23 5/8 " Max. seat depth: 48 7/8 " Seat height: 17 3/4 "',
        2355,
        300),


        ('Sofa, Gunnared dark gray / wood',
        'https://www.ikea.com/us/en/images/products/morabo-sofa-gunnared-dark-gray-wood__0815940_pe773127_s5.jpg?f=s',
        'Warm and welcoming, neat and stylish. The supporting seat cushions, the cover''s soft finish and the tight fit gives this sofa a perfect balance between its comfort, functions and look.',
        'Seat cushions filled with high-resilience foam and polyester fiber wadding provide great seating comfort. These wooden legs give Morabo sofa and armchair a warm and natural look. Removable armrests make it easy to add on a chaise lounge. This cover is made of dope-dyed Gunnared fabric in polyester. It is a durable fabric with a wool-like feel, a warm look and a two-toned melange effect.',
        'Width: 101 5/8 " Seat width, chaise lounge: 26 3/4 " Depth: 64 5/8 " Height: 36 1/4 " Seat depth, chaise lounge: 51 1/8 " Height under furniture: 6 3/4 " Armrest height: 26 3/4 " Seat width: 79 7/8 " Seat depth: 22 7/8 " Seat height: 18 1/2 "',
        2975,
        450),


       ('Sectional 5-seat corner, with chaise',
        'https://www.ikea.com/us/en/images/products/finnala-sectional-5-seat-corner-with-chaise-gunnared-beige__0787118_pe763151_s5.jpg?f=xxs',
        'finnala sectional sofa can grow and change with a home and the family. Choose how many seats, the look and function to create a sofa that suits you. A clean design and long-lasting comfort are included',
        'Seat cushions filled with high-resilience foam and polyester fiber wadding provide great seating comfort. The contact surfaces are covered with Gran a soft, smooth and strong grain leather with natural variations. Other surfaces have Bomsand, a coated fabric that has a similar look and feel to leather. Removable armrests make it easy to add on a chaise lounge. 10-year limited warranty. Read about the terms in the limited warranty brochure.',
        'width: 110 1/4 " Height: 32 5/8 " Min. depth: 37 3/8 " Max. depth: 64 1/8 " Min. seat depth: 23 5/8 " Max. seat depth: 48 7/8 " Seat height: 17 3/4 "',
        4590,
        150),


        ('Sofa, with chaise / Grann / metal',
        'https://www.ikea.com/us/en/images/products/morabo-sofa-with-chaise-grann-bomstad-dark-beige-metal__0816247_pe773397_s5.jpg?f=s',
        'Warm and welcoming, neat and stylish. The supporting seat cushions, the cover''s soft finish and the tight fit gives this sofa a perfect balance between its comfort, functions and look.',
        'Classic design with soft, rounded shapes and generously sized armrests makes Viskafore sofa a statement piece in any living room. The deep seat with pocket springs is really soft and creates an inviting, embracing feel when you sit on the sofa. Skillful craftsmanship and a perfect fit means that the sofa will always shows off its best side. You can choose from several different covers and legs in 2 colors. Made of quality leather that ages gracefully and develops a nice patina over time.',
        'Armrest width: 8 5/8 " Depth: 35 3/8 " Height under furniture: 4 3/8 " Height: 29 1/8 " Seat depth: 23 5/8 " Seat height: 18 1/8 " Seat width: 70 1/8 " Width: 88 1/4 ',
        3570,
        500),

        ('Sectional, 4-seat, with chaise Bomstad golden brown',
        'https://www.ikea.com/us/en/images/products/finnala-sectional-4-seat-with-chaise-grann-bomstad-golden-brown__0817645_pe774071_s5.jpg?f=s',
        'Finnala sectional sofa can grow and change with a home and the family. Choose how many seats, the look and function to create a sofa that suits you. A clean design and long-lasting comfort are included.',
        'This comfortable sofa has pocket spring seat cushions with high resilience foam and a top layer of wadding. It provides a nice comfort and support for your body while maintaining the shape of the seat cushions. The contact surfaces are covered with grann  a soft, smooth and strong grain leather with natural variations. Other surfaces have bomstan, a coated fabric that has a similar look and feel to leather. The sofas sections can be combined in different ways to get a size and shape that suits you. If you need a larger sofa, you can add a section or two. Storage space under the chaise. The lid stays open so you can safely and easily take things in and out. You can place the chaise section to the left or right of the sofa, and switch whenever you like.',
        'width: 110 1/4 " Height: 32 5/8 " Min. depth: 37 3/8 " Max. depth: 64 1/8 " Min. seat depth: 23 5/8 " Max. seat depth: 48 7/8 " Seat height: 17 3/4 "',
        1849,
        200);

INSERT INTO user (first_name, last_name, email, phone, city, street, buildingNumber, apartment, username,  password, roles, permissions) VALUES
    ('avi', 'david','e@hgh.com', '154554555', 'hatikva', 'bar', 15,  5, 'a', 'a', '', ''),
    ('dd', 'david','kfjkd@hgh.com', 'fgtgg', 'hhh', 'vfd', 15,  5, 'b', 'b', '', '');

