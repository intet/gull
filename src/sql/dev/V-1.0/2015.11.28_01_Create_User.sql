--liquibase formatted sql
--changeset Sivodedov Dmitry:Create_User
INSERT INTO USERS VALUES
  ('8a59d9547e5b4d9ca0a30804e8a33a94', 'admin', '$2a$10$GZtUdy1Z7Hpk0lYYG92CQeiW1f2c4e3XgA8wunVTDFyQJ2DAmH.x.', TRUE);
INSERT INTO AUTHORITIES VALUES (1, '8a59d9547e5b4d9ca0a30804e8a33a94', 'ROLE_ADMIN');
INSERT INTO AUTHORITIES VALUES (2, '8a59d9547e5b4d9ca0a30804e8a33a94', 'ROLE_USER');
--rollback delete from AUTHORITIES where userId = '8a59d9547e5b4d9ca0a30804e8a33a94';
--rollback delete from USERS where id = '8a59d9547e5b4d9ca0a30804e8a33a94';
