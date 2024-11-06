--DROP SCHEMA IF EXISTS general CASCADE;

CREATE SCHEMA IF NOT EXISTS general;

--UTILS SCHEMA

CREATE TABLE general.person
(
    id   uuid    NOT NULL,
    name varchar NOT NULL,
    age  int4 NOT NULL,
    role varchar NOT NULL,
    user_name varchar NOT NUll,
    CONSTRAINT pk_person
        PRIMARY KEY (id)
);
