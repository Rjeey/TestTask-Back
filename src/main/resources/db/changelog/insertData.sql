--users
INSERT INTO usr (id,created, updated, login,password)
values(1,'2020-01-01','2020-01-01','USER1','$2a$10$Qo7EvhqzgktJErcopT1aWOXNWedCeZWcfs5C3vu/6BJ6WPaatR07G'); --12345678

INSERT INTO usr (id,created, updated, login,password)
values(2,'2020-01-01','2020-01-01','USER2','$2a$10$MlbDqOEuWkzK/lKTxo1oEeVJufaGOewRopofiSHwfh5HXK74IpbVG'); --45617273

-- roles
INSERT INTO role (id,name)
VALUES (1,'USER');

INSERT INTO role (id,name)
VALUES (2,'USER');

-- user roles
INSERT INTO usr_role (user_id, role_id)
VALUES (2, 2);

INSERT INTO usr_role (user_id, role_id)
VALUES (1, 1);