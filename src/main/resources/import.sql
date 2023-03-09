insert into roles(role_id, role) values (1, 'ADMIN');
insert into roles(role_id, role) values (2, 'USER');
insert into users (user_id, email, name, password, active) values (10, 'me@example.com', 'catrix', '$2a$10$7/QlqfBic36TVIsHUqvvG.ekZqtVOCT24J0MM49qr2WwzjKyhjvFq', true);
insert into user_role(role_id, user_id) values(1, 10);