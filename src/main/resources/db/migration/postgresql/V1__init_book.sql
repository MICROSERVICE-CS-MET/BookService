CREATE EXTENSION IF NOT EXISTS "uuid-ossp";


CREATE TABLE book
(
    id                     uuid         NOT NULL DEFAULT uuid_generate_v4(),
    name              varchar(255)         NOT NULL,
    description            varchar(450) NOT NULL,
    category                 varchar(30)         NOT NULL,
    page_count                int       NOT NULL,
    stock                int       NOT NULL,
    price                DECIMAL       NOT NULL,


    PRIMARY KEY (id)
);

