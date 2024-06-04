DROP SCHEMA IF EXISTS general CASCADE;

CREATE SCHEMA IF NOT EXISTS general;

--UTILS SCHEMA

CREATE TABLE general.person
(
    id   uuid    NOT NULL,
    name varchar NOT NULL,
    age  int4 NOT NULL,
    CONSTRAINT pk_person
        PRIMARY KEY (id)
);
