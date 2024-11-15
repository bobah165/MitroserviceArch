--DROP SCHEMA IF EXISTS general CASCADE;

CREATE SCHEMA IF NOT EXISTS general;

--UTILS SCHEMA

CREATE TABLE general.person
(
    id   varchar   NOT NULL,
    name varchar NOT NULL,
    age  int4 NOT NULL,
    user_role varchar NOT NUll,
    pass varchar NOT NULL,
    CONSTRAINT pk_person
        PRIMARY KEY (id)
);
