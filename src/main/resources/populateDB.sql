DELETE FROM user_role;
DELETE FROM vote;
DELETE FROM meal;
DELETE FROM restaurant;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 1000000;

INSERT INTO users (name, email, password)
VALUES ('Admin', 'admin@mail.com', 'admin_password'),
       ('User_1', 'user_1@mail.com', 'user_1_password'),
       ('User_2', 'user_2@mail.com', 'user_2_password'),
       ('User_3', 'user_3@mail.com', 'user_3_password');

INSERT INTO user_role (user_id, role)
VALUES (1000000, 'ADMIN'),
       (1000001, 'USER'),
       (1000002, 'USER'),
       (1000003, 'USER');

INSERT INTO restaurant (name, address, description)
VALUES ('KFC', 'Краснодар, ул. Красная, д. 76', 'фаст фуд'),
       ('Чистые ручки', 'Краснодар, ул. Чехова, д. 6', 'столовая'),
       ('Белый лебедь', 'Краснодар, ул. Ленина, д. 10', 'дорогой ресторан');

INSERT INTO meal (restaurant_id, name, date, price)
VALUES (1000004, 'куриные крылышки', now(), 400),
       (1000004, 'картофель фри', now(), 250),
       (1000004, 'спрайт', now(), 100),
       (1000004, 'фанта', now(), 100),
       (1000005, 'картофельное пюре', now(), 170),
       (1000005, 'котлета по-киевски', now(), 250),
       (1000005, 'борщ', now(), 200),
       (1000005, 'чай', now(), 40),
       (1000005, 'какао', now(), 70),
       (1000006, 'стейк', now(), 1500),
       (1000006, 'омлет', now(), 650),
       (1000006, 'грибной крем-суп', now(), 800),
       (1000006, 'мороженое', now(), 300),
       (1000006, 'кофе', now(), 250),
       (1000006, 'лимонад', now(), 350);

INSERT INTO vote (user_id, restaurant_id, date_time)
VALUES (1000000, 1000005, now()),
       (1000001, 1000006, now()),
       (1000002, 1000006, now()),
       (1000003, 1000004, now());
