DROP SCHEMA IF EXISTS Sep2 CASCADE;

CREATE SCHEMA Sep2;
SET SCHEMA 'sep2';

CREATE TABLE InputUser(
                          id serial not null ,
                          user_ varchar(20) not null ,
                          primary key (id)
);

CREATE TABLE InputChat(
    chat varchar(3000)

);


CREATE TABLE flights(
                        flightname varchar(20),
                        seats varchar(20)


);

INSERT INTO flights(flightname, seats) values ('F1','1');
INSERT INTO flights(flightname, seats) values ('F2','2');
INSERT INTO flights(flightname, seats) values ('F3','4');
INSERT INTO flights(flightname, seats) values ('F4','5');
INSERT INTO flights(flightname, seats) values ('F5','6');

