CREATE TABLE IF NOT EXISTS usr
(
    id       serial       not null primary key,
    surname  varchar(255) not null,
    name     varchar(255) not null,
    email    varchar(255) not null,
    password varchar(255) not null,
    role     varchar(255) not null
);

INSERT INTO usr (surname, name, email, password, role)
VALUES ('Tramp', 'Donald', 'tramp@mail.com', '$2a$12$BrpOm2REpVodNhoBZDsAD.qBk.e/5GM0CyFl/Gx6OPXXSm2bhpwHK', 'USER'),
       ('Jackson', 'Samuel', 'samuel@mail.com', '$2a$12$BrpOm2REpVodNhoBZDsAD.qBk.e/5GM0CyFl/Gx6OPXXSm2bhpwHK', 'ADMIN'),
       ('Fisher', 'Jeff', 'jeff@mail.com', '$2a$12$BrpOm2REpVodNhoBZDsAD.qBk.e/5GM0CyFl/Gx6OPXXSm2bhpwHK', 'USER'),
       ('Lee', 'Stan', 'stan@mail.com', '$2a$12$BrpOm2REpVodNhoBZDsAD.qBk.e/5GM0CyFl/Gx6OPXXSm2bhpwHK', 'USER');