CREATE TABLE if not exists users (
    user_id CHAR(32) DEFAULT ' ' NOT NULL,
    email VARCHAR(255) DEFAULT ' ' NOT NULL,
    name VARCHAR(255) DEFAULT ' ' NOT NULL,
    password VARCHAR (255) DEFAULT ' ' NOT NULL,
    active VARCHAR (32) DEFAULT ' ' NOT NULL
);

CREATE TABLE if not exists roles (
    role_id CHAR(32) DEFAULT ' ' NOT NULL,
    role VARCHAR (255) DEFAULT ' ' NOT NULL
);


CREATE TABLE if not exists user_role (
    role_id CHAR(32) DEFAULT ' ' NOT NULL,
    user_id CHAR (32) DEFAULT ' ' NOT NULL
);

DELETE FROM user_role;
DELETE FROM users;
DELETE FROM roles;
