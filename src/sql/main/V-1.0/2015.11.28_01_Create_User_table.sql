--liquibase formatted sql
--changeset Sivodedov Dmitry:CREATE_TABLE_Users
CREATE TABLE Users (
  id       BINARY(16)             NOT NULL PRIMARY KEY,
  username VARCHAR_IGNORECASE(50) NOT NULL,
  password VARCHAR(60)            NOT NULL,
  enabled  BOOLEAN                NOT NULL
);
--rollback drop table Users;

--changeset Sivodedov Dmitry:CREATE_TRIGGER_TRIG_BI_DM_USERS splitStatements:false
CREATE TRIGGER TRIG_BI_DM_USERS BEFORE INSERT ON Users
  REFERENCING NEW AS NEW
FOR EACH ROW
  BEGIN ATOMIC
    IF NEW.id IS NULL
    THEN
      -- noinspection SqlResolve
      SET NEW.id = UUID();
    END IF;
  END;

--rollback drop TRIGGER TRIG_BI_DM_USERS on Users;

--changeset Sivodedov Dmitry:CREATE_TABLE_Authorities
CREATE TABLE Authorities (
  id        BIGINT IDENTITY        NOT NULL PRIMARY KEY,
  userId    BINARY(16)             NOT NULL,
  authority VARCHAR_IGNORECASE(50) NOT NULL,
  CONSTRAINT fk_authorities_users FOREIGN KEY (userId) REFERENCES users (id)
);
--rollback drop table Authorities;

--changeset Sivodedov Dmitry:CREATE_INDEX_ix_auth_username
CREATE UNIQUE INDEX ix_auth_username ON Authorities (userId, authority);
--rollback drop INDEX ix_auth_username on Authorities;