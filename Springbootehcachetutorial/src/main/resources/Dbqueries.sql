create table if not exists product (
	product_id int(10) not null auto_increment,
	product_name varchar(50) not null,
	product_price decimal(4,1) null,
	primary key  (product_id)
);

insert into product (product_id, product_name, product_price) values (1, 'Turnip - Mini', 353.29);
insert into product (product_id, product_name, product_price) values (2, 'Sobe - Cranberry Grapefruit', 557.58);
insert into product (product_id, product_name, product_price) values (3, 'Soup - Campbells, Creamy', 963.35);
insert into product (product_id, product_name, product_price) values (4, 'Rice - Brown', 281.87);
insert into product (product_id, product_name, product_price) values (5, 'Sour Puss Raspberry', 322.67);
insert into product (product_id, product_name, product_price) values (6, 'Apples - Sliced / Wedge', 899.83);
insert into product (product_id, product_name, product_price) values (7, 'Bread - White, Unsliced', 969.27);
insert into product (product_id, product_name, product_price) values (8, 'Jam - Raspberry,jar', 785.06);
insert into product (product_id, product_name, product_price) values (9, 'Bagel - Everything', 944.77);
insert into product (product_id, product_name, product_price) values (10, 'Sauce - Oyster', 877.9);
insert into product (product_id, product_name, product_price) values (11, 'Cranberries - Frozen', 747.52);
insert into product (product_id, product_name, product_price) values (12, 'Bread - Kimel Stick Poly', 669.52);
insert into product (product_id, product_name, product_price) values (13, 'Tomatoes - Cherry, Yellow', 533.1);
insert into product (product_id, product_name, product_price) values (14, 'Garlic - Elephant', 262.16);
insert into product (product_id, product_name, product_price) values (15, 'Yogurt - Cherry, 175 Gr', 690.96);
insert into product (product_id, product_name, product_price) values (16, 'Chicken - Leg / Back Attach', 104.69);
insert into product (product_id, product_name, product_price) values (17, 'Wine - Champagne Brut Veuve', 577.09);
insert into product (product_id, product_name, product_price) values (18, 'Pepper - Scotch Bonnet', 218.87);
insert into product (product_id, product_name, product_price) values (19, 'Sesame Seed Black', 244.4);
insert into product (product_id, product_name, product_price) values (20, 'Remy Red Berry Infusion', 306.14);