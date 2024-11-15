--liquibase formatted SQL
--changeset Greg:1
insert into general.person (id, name, age, user_role, pass) values ('1', '${nameAdmin}', 20, 'admin', '${passwordAdmin}');
insert into general.person (id, name, age, user_role, pass) values ('2', '${nameUser}', 21, 'user1', '${passwordUser}');


