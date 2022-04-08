CREATE TABLE IF NOT EXISTS usr
(
    id       serial       not null primary key,
    surname  varchar(255) not null,
    name     varchar(255) not null,
    email    varchar(255) not null,
    password varchar(255) not null,
    role     varchar(255) not null
);